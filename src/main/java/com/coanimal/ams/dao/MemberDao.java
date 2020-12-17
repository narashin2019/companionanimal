package com.coanimal.ams.dao;

import java.util.Map;
import com.coanimal.ams.domain.Member;

//20201215
public interface MemberDao {

  // 회원가입
  public void register(Member member) throws Exception;
  
  // 로그인
  //public Member login(Member member) throws Exception;
  
  //회원정보 수정
  public void memberUpdate(Member member)throws Exception;
  
  // 로그인 (아이디 패스워드 일치 확인)
  public Member findByEmailAndPassword(Map<String, Object> params) throws Exception;
}


