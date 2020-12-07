package com.coanimal.ams.dao;

import com.coanimal.ams.domain.Member;

//20201207
public interface MemberDao {

  // 회원가입
  public void register(Member member) throws Exception;
  
  // 로그인
  public Member login(Member member) throws Exception;
}


