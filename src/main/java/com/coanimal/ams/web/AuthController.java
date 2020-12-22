package com.coanimal.ams.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.coanimal.ams.domain.Member;
import com.coanimal.ams.service.MemberService;

//20201215

@Controller
@RequestMapping("/auth")
public class AuthController {
  
  static Logger logger = LogManager.getLogger(AuthController.class);

  @Autowired
  MemberService memberService;
  
  public AuthController() {
    logger.debug("AuthController 생성됨!");
  }

  
  // 로그인 GET
  @GetMapping("login")
  public void login() {}

  // 로그인 POST
  @PostMapping("login")
  public String login( //
      String email, //
      String password, //
      String saveEmail, //
      HttpServletResponse response, //
      HttpSession session, //
      Model model) throws Exception {

    Cookie cookie = new Cookie("email", email);
    if (saveEmail != null) {
      cookie.setMaxAge(60 * 60 * 24 * 30);
    } else {
      cookie.setMaxAge(0);
    }
    response.addCookie(cookie);

    Member member = memberService.findByEmailAndPassword(email, password);
    
    if (member != null) {
      session.setAttribute("loginUser", member);
      model.addAttribute("refreshUrl", "2;url=../../");
    } else {
      session.invalidate();
      model.addAttribute("refreshUrl", "2;url=login");
    }

    return "auth/loginResult";
  }

  // 로그아웃 : 세션만 끊어주면 된다.
  @GetMapping("logout")
  public String logout(HttpSession session) {
    session.invalidate();
    // 리턴값은 "redirect:../../index.jsp" 또는 "redirect:../../" 만 된다. 
    // "redirect:../../index" 는 안된다. 컨트롤러가 있어도 /app/* 설정이 되어 있어서
    return "redirect:../../";
  }

  
}



