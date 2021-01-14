package com.coanimal.ams.service.impl;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import com.coanimal.ams.dao.MemberDao;
import com.coanimal.ams.domain.Member;
import com.coanimal.ams.service.MemberService;
import com.coanimal.ams.util.MailHandler;
import com.coanimal.ams.util.Tempkey;

@Component
public class MemberServiceImpl implements MemberService {
  

  @Autowired
  private JavaMailSender mailSender;
  
  
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
    // 디비에 회원가입 정보 저장
    memberDao.register(member);
    
    // 인증키 생성
    String key = new Tempkey().getKey(10, false);
    // 인증키 디비에 저장
    memberDao.createAuthkey(member.getEmail(), key);
  
    // 메일 발송
    MailHandler sendMail = new MailHandler(mailSender);
    
    sendMail.setSubject("[companionanimal 회원가입 서비스 이메일 인증 입니다.]");
    sendMail.setText(new StringBuffer().append("<h1>companionanimal 가입 메일인증 입니다</h1>")
        .append("<a href='http://localhost:9999/companionanimal/app/member/emailConfirm?email=")
        .append(member.getEmail()).append("&key=").append(key)
        .append("' target='_blenk'>가입 완료를 위해 이메일 이곳을 눌러주세요</a>").toString());
    sendMail.setFrom("coanimal547@gmail.com", "companionanimal");
    sendMail.setTo(member.getEmail());
    sendMail.send();
    
  }

  // authstatus 1로 변경
  @Override
  public void updateAuthstatus(String email) throws Exception {
      memberDao.updateAuthstatus(email);
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
  public Member findByEmailAndPassword(String email, String password) throws Exception {
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

  // 회원 탈퇴
  @Override
  public void memberDelete(Member member) throws Exception {
    memberDao.memberDelete(member);
  }
  
  //패스워드 체크
  @Override
  public int passChk(Member member) throws Exception {
     int result = memberDao.passChk(member);
     return result;
  }

  // 이메일 중복 체크
  @Override
  public int idChk(Member member) throws Exception {
     int result = memberDao.idChk(member);
     return result;
  }
  
  // 닉네임 중복 체크
  @Override
  public int nameChk(Member member) throws Exception {
     int result = memberDao.nameChk(member);
     return result;
  }
  

}
