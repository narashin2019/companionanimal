package com.coanimal.ams.service.impl;

import org.springframework.stereotype.Component;
import com.coanimal.ams.dao.MemberDao;
import com.coanimal.ams.domain.Member;
import com.coanimal.ams.service.MemberService;

@Component
public class MemberServiceImpl implements MemberService {

  MemberDao memberDao;

  // 회원가입
  @Override
  public void register(Member member) throws Exception {
    memberDao.register(member);
  }

  // 로그인
  @Override
  public Member login(Member member) throws Exception {
    return memberDao.login(member);
  }


}
