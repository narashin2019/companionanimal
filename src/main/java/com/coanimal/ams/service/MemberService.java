package com.coanimal.ams.service;

import com.coanimal.ams.domain.Member;

//20201215
public interface MemberService {

  // 회원가입
  public void register(Member member) throws Exception;

  // 회원정보 변경
  public void memberUpdate(Member member) throws Exception;

  //로그인 (아이디 패스워드 일치 확인)
  public Member get(String email, String password) throws Exception;
  
  // 회원정보 조회 (마이페이지)
  public Member userView(String email) throws Exception;
}
