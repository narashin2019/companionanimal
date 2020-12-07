package com.coanimal.ams.service;

import com.coanimal.ams.domain.Member;

public interface MemberService {

  // 회원가입
  public void register(Member member) throws Exception;

  // 로그인
  public Member login(Member member) throws Exception;


}
