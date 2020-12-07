package com.coanimal.ams.service.impl;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.coanimal.ams.dao.InfoReplyDao;
import com.coanimal.ams.domain.InfoReply;
import com.coanimal.ams.service.InfoReplyService;

@Service
public class InfoReplyServiceImpl implements InfoReplyService {

  @Inject
  InfoReplyDao infoReplyDao;
  
  // 댓글 조회
  @Override
  public List<InfoReply> readReply(int infoNo) throws Exception {
    return infoReplyDao.readReply(infoNo);
  }

  // 댓글 작성
  @Override
  public void writeReply(InfoReply infoReply) throws Exception {
    infoReplyDao.writeReply(infoReply);
  }
  
  // 댓글 수정
  @Override
  public void updateReply(InfoReply infoReply) throws Exception {
    infoReplyDao.updateReply(infoReply);
  }
  
  // 댓글 삭제
  @Override
  public void deleteReply(InfoReply infoReply) throws Exception {
    infoReplyDao.deleteReply(infoReply);
  }

  // 선택된 댓글 조회
  @Override
  public InfoReply selectReply(int infoReplyNo) throws Exception {
    return infoReplyDao.selectReply(infoReplyNo);
  }
  
}
