package com.coanimal.ams.service.impl;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.coanimal.ams.dao.WalkReplyDao;
import com.coanimal.ams.domain.WalkReply;
import com.coanimal.ams.service.WalkReplyService;

@Service
public class WalkReplyServiceImpl implements WalkReplyService {

  @Inject
  WalkReplyDao walkReplyDao;

  // 댓글 조회
  @Override
  public List<WalkReply> readReply(int walkNo) throws Exception {
    return walkReplyDao.readReply(walkNo);
  }

  // 댓글 작성
  @Override
  public void writeReply(WalkReply walkReply) throws Exception {
    walkReplyDao.writeReply(walkReply);
  }

  // 댓글 수정
  @Override
  public void updateReply(WalkReply walkReply) throws Exception {
    walkReplyDao.updateReply(walkReply);
  }

  // 댓글 삭제
  @Override
  public void deleteReply(WalkReply walkReply) throws Exception {
    walkReplyDao.deleteReply(walkReply);
  }

  // 선택된 댓글 조회
  @Override
  public WalkReply selectReply(int infoReplyNo) throws Exception {
    return walkReplyDao.selectReply(infoReplyNo);
  }

}