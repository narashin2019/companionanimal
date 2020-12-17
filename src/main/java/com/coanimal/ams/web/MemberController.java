package com.coanimal.ams.web;

import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
      
      return "redirect:../auth/login";
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
  
  // 회원정보 조회 (마이페이지) GET
  @GetMapping("/mypage")
  public String mypage() {
    return "member/mypage";
  }
  
}

