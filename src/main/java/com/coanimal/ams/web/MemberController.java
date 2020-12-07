package com.coanimal.ams.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.coanimal.ams.domain.Member;
import com.coanimal.ams.service.MemberService;

//20201207

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
      memberService.register(member);
      return "redirect:login";
  }

  // 로그인
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(Member member, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
      logger.info("post login");
      
      HttpSession session = req.getSession();
      Member login = memberService.login(member);
      
      if(login == null) {
          session.setAttribute("member", null);
          rttr.addFlashAttribute("msg", false);
      }else {
          session.setAttribute("member", login);
      }
      return "redirect:../../index.html";
  }
  
  // 로그아웃
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(HttpSession session) throws Exception{
      
      session.invalidate();
      return "redirect:../../index.html";
  }
  
  
}
