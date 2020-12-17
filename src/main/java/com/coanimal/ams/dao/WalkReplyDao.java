package com.coanimal.ams.dao;

import java.util.List;
import com.coanimal.ams.domain.WalkReply;

// 데이터를 저장하고 꺼내는 방식(파일, 클라우드저장소, DB 등)에 상관없이
// DAO 사용법을 통일하기 위해
// 메서드 호출 규칙을 정의한다.
//
public interface WalkReplyDao {

  // 댓글 조회
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


