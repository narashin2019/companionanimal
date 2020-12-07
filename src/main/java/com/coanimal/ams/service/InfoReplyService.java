package com.coanimal.ams.service;

import java.util.List;
import com.coanimal.ams.domain.InfoReply;

public interface InfoReplyService {

  // 댓글 조회
  public List<InfoReply> readReply(int infoNo) throws Exception;
  
  // 댓글 작성
  public void writeReply(InfoReply infoReply) throws Exception;

  // 댓글 수정
  public void updateReply(InfoReply infoReply) throws Exception;

  // 댓글 삭제
  public void deleteReply(InfoReply infoReply) throws Exception;

  // 선택된 댓글 조회
  public InfoReply selectReply(int infoReplyNo) throws Exception;


}
