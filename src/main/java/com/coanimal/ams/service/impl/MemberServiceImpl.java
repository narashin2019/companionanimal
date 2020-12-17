package com.coanimal.ams.service.impl;

import java.util.HashMap;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import com.coanimal.ams.dao.MemberDao;
import com.coanimal.ams.domain.Member;
import com.coanimal.ams.service.MemberService;

//20201215

@Component
public class MemberServiceImpl implements MemberService {

  TransactionTemplate transactionTemplate;
  //@Inject(import javax.inject.Injec;)를 쓰거나 생성자를 만들거나 둘중하나 꼭 해야함
  MemberDao memberDao;
  
  public MemberServiceImpl(PlatformTransactionManager txManager, MemberDao memberDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.memberDao = memberDao;
  }

  // 회원가입
  @Override
  public void register(Member member) throws Exception {
    memberDao.register(member);
  }

 
  // Controller에서 보내는 파라미터들을 memberUpdate(Member member)로 받고
  // 받은 도메인을 DAO로 보내준다
  // 회원정보 변경
  @Override
  public void memberUpdate(Member member) throws Exception {
    memberDao.memberUpdate(member);
  }
  
  //로그인 (아이디 패스워드 일치 확인)
  @Override
  public Member get(String email, String password) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("email", email);
    params.put("password", password);
    return memberDao.findByEmailAndPassword(params);
  }
  
  // 회원정보 조회 (마이페이지)
  @Override
  public Member userView(String email) throws Exception {
    return memberDao.userView(email);
  }
  

}
