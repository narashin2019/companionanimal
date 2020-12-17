package com.coanimal.ams.web;

import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.coanimal.ams.domain.Member;
import com.coanimal.ams.service.MemberService;

//20201215

@Controller
@RequestMapping("/member")
public class MemberController {
  
  static Logger logger = LogManager.getLogger(MemberController.class);

  @Autowired
  MemberService memberService;
  
  public MemberController() {
    logger.debug("MemberController 생성됨!");
  }

  // 회원가입 폼 GET
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public void getRegister() throws Exception {
  }

  // 회원가입 POST
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String postRegister(Member member) throws Exception {
      System.out.println("member"+ member);
      memberService.register(member);
      
      return "redirect:/";
  }
  
  // 회원정보 수정 GET
  @RequestMapping(value="/memberUpdateView", method = RequestMethod.GET)
  public void registerUpdateView() throws Exception{
  }

  // 회원정보 수정 POST
  @RequestMapping(value="/memberUpdate", method = RequestMethod.POST)
  public String registerUpdate(Member member, HttpSession session) throws Exception{
      
      memberService.memberUpdate(member);
      session.invalidate();
      
      return "member/mypage";
  }
  
  // 마이페이지 GET
  @RequestMapping(value="/mypage", method = RequestMethod.GET)
  public void mepageView() throws Exception{
  }
  
}


//// 로그인 GET
//@RequestMapping(value = "/login", method = RequestMethod.GET)
//public void login() throws Exception {
//}
//@RequestMapping(value = "/login", method = RequestMethod.POST)
//public String login(Member member, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
//  logger.info("post login");
//  
//  HttpSession session = req.getSession();
//  Member login = memberService.login(member);
//  
//  if(login == null) {
//      session.setAttribute("member", null);
//      rttr.addFlashAttribute("msg", false);
//  }else {
//      session.setAttribute("member", login);
//  }
//  System.out.println("세션받아와졌냐" + session);
//  System.out.println("세션받아와졌냐" + login);
//  return "redirect:/";
//  // redirect:/로 리턴하면 index.html페이지가 나옴 // redirect:../home/home :
//}
//// 로그아웃
//@RequestMapping(value = "/logout", method = RequestMethod.GET)
//public String logout(HttpSession session) throws Exception{
//  
//  session.invalidate();
//  return "redirect:/";
//}
