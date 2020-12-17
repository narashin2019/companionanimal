package com.coanimal.ams.service;

import java.util.List;
import com.coanimal.ams.domain.WalkReply;

public interface WalkReplyService {

  //댓글 조회
  public List<WalkReply> readReply(int walkNo) throws Exception;

  // 댓글 작성
  public void writeReply(WalkReply walkReply) throws Exception;

  // 댓글 수정
  public void updateReply(WalkReply walkReply) throws Exception;

  // 댓글 삭제
  public void deleteReply(WalkReply walkReply) throws Exception;

  // 선택된 댓글 조회
  public WalkReply selectReply(int walkReplyNo) throws Exception;
}