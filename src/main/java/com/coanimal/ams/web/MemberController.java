package com.coanimal.ams.web;

import java.io.File;
import java.util.UUID;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.coanimal.ams.domain.Member;
import com.coanimal.ams.service.MemberService;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/member")
public class MemberController {
  
  static Logger logger = LogManager.getLogger(MemberController.class);

  @Autowired
  ServletContext servletContext;

  @Autowired
  MemberService memberService;
  
  @Inject
  BCryptPasswordEncoder pwdEncoder;
  
  public MemberController() {
    logger.debug("MemberController 생성됨!");
  }

  // 회원가입 폼 GET
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public void getRegister() throws Exception {
  }

  // 회원가입 POST
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String postRegister(Member member, Model model, HttpServletRequest request) throws Exception {
      
    int result = memberService.idChk(member);
    
    int result2 = memberService.nameChk(member);
    
    try {
      if(result == 1 || result2 == 1) {
    
        model.addAttribute("result", "fail");
        model.addAttribute("refreshUrl", "2;url=register");
        
      } else if (result==0 && result2 == 0) {
        String inputPass = member.getPassword();
        String pwd = pwdEncoder.encode(inputPass);
        member.setPassword(pwd);
        
        memberService.register(member);
        
        model.addAttribute("result", "ok");
        model.addAttribute("refreshUrl", "2;url=../auth/login");
      }
      
    } catch (Exception e) {
      throw new RuntimeException();
    }
    
    return "member/registerResult";
  }

  
  // 회원정보 수정 GET
  @RequestMapping(value="/memberUpdateForm", method = RequestMethod.GET)
  public void memberUpdateForm() throws Exception{
  }

  // 회원정보 수정 POST
  @RequestMapping(value="/memberUpdate", method = RequestMethod.POST)
  public String memberUpdate(Member member, HttpSession session, @RequestPart(value = "photo", required = false) MultipartFile photo) throws Exception{
    
    System.out.println("멤버아이디포토 =" + member.getIdPhoto()); // 입력화면에서 넘기는 것이 있으면 null아님 사진변경을 하지 않으면 null
   
    // 그러나 photo와 null로 비교하지 말고 파일네임이나 파일 사이즈로 비교해야 한다. 
    if (photo.getOriginalFilename() !=null && photo.getOriginalFilename() != "") {
      String dirPath = servletContext.getRealPath("/upload/member");
      String filename = UUID.randomUUID().toString();
      
      photo.transferTo(new File(dirPath + "/" + filename));
      
      Thumbnails.of(dirPath + "/" + filename).size(160, 160).outputFormat("jpg")
      .toFiles(Rename.PREFIX_DOT_THUMBNAIL);
      
      member.setIdPhoto(filename);
      System.out.println("1 = " + member.getIdPhoto());//사진 변경 없을 시 null 값이 나옴
    } 

    System.out.println("2 = " + member.getIdPhoto()); //사진 변경 없을 시 null 값이 나옴
    
    
    memberService.memberUpdate(member);
    System.out.println("3 = " +member.getIdPhoto()); //사진 변경 없을 시 null 값이 나옴
    
    session.removeAttribute("loginUser");
    session.setAttribute("loginUser", memberService.userView(member.getEmail()));
    
    return "redirect:../member/mypage";
      
  }
  
  // 회원 탈퇴 get
  @RequestMapping(value="/memberDeleteForm", method = RequestMethod.GET)
  public String memberDeleteView() throws Exception{
      return "member/memberDeleteForm";
  }
  
  // 회원 탈퇴 post
  @RequestMapping(value="/memberDelete", method = RequestMethod.POST)
  public String memberDelete(Member member, HttpSession session, RedirectAttributes rttr) throws Exception{
      
   
//    // 세션에 있는 member를 가져와 mbr변수에 넣어준다
//    Member mbr = (Member) session.getAttribute("loginUser");
//    
//    // 세션에있는 비밀번호
//    String sessionPass = mbr.getPassword();
//   
//    // vo로 들어오는 비밀번호
//    String voPass = member.getPassword();
//    
//    // 세션 비밀번호와 vo 비밀번호가 같지 않다면
//    if(!(sessionPass.equals(voPass))) {
//        rttr.addFlashAttribute("msg", false);
//        return "redirect:memberDeleteForm";
//    }
    
    memberService.memberDelete(member);
    session.invalidate();
    return "redirect:/";
  }
  
  // 회원정보 조회 (마이페이지) GET
  @GetMapping("/mypage")
  public String mypage() {
    return "member/mypage";
  }
  
  // 패스워드 체크
  @ResponseBody
  @RequestMapping(value="/passChk", method = RequestMethod.POST)
  public boolean passChk(Member member) throws Exception {
    String email = member.getEmail();
    String password = member.getPassword();
     
    Member login = memberService.findByEmailAndPassword(email, password);
    boolean pwdChk = pwdEncoder.matches(member.getPassword(), login.getPassword());  
  
    return pwdChk;
  }
  
  // 이메일 중복 체크
  @ResponseBody
  @RequestMapping(value="/idChk", method = RequestMethod.POST)
  public int idChk(Member member) throws Exception {
     int result = memberService.idChk(member);
     return result;
  }
  
  // 닉네임 중복 체크
  @ResponseBody
  @RequestMapping(value="/nameChk", method = RequestMethod.POST)
  public int nameChk(Member member) throws Exception {
     int result = memberService.nameChk(member);
     return result;
  }
  
  // 이메일 인증
  @RequestMapping(value = "/emailConfirm", method = RequestMethod.GET)
  public String emailConfirm(String email, Model model) throws Exception {
          memberService.updateAuthstatus(email);
          model.addAttribute("email", email);

          return "member/emailConfirm"; // emailConfirm.jsp
  }
  
}

