package com.coanimal.ams.service;

import com.coanimal.ams.domain.Member;

//20201215
public interface MemberService {

  // 회원가입
  public void register(Member member) throws Exception;

  // 회원정보 변경
  public void memberUpdate(Member member) throws Exception;

  //로그인 (아이디 패스워드 일치 확인)
  public Member findByEmailAndPassword(String email, String password) throws Exception;
  
  // 회원정보 조회 (마이페이지)
  public Member userView(String email) throws Exception;
  
  // 회원 탈퇴
  public void memberDelete(Member member) throws Exception;
  
  // 패스워드 체크
  public int passChk(Member member) throws Exception;
  
  // 이메일 중복 체크
  public int idChk(Member member) throws Exception;
  
  // 닉네임 중복 체크
  public int nameChk(Member member) throws Exception;
}
