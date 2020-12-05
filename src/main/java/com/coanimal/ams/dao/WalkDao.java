package com.coanimal.ams.dao;

import java.util.List;
import com.coanimal.ams.domain.Walk;

// 데이터를 저장하고 꺼내는 방식(파일, 클라우드저장소, DB 등)에 상관없이
// DAO 사용법을 통일하기 위해
// 메서드 호출 규칙을 정의한다.
//
public interface WalkDao {
  public int insert(Walk walk) throws Exception;

  public List<Walk> findAll() throws Exception;

  public Walk findByNo(int walkNo) throws Exception;

  public int update(Walk walk) throws Exception;

  public int delete(int walkNo) throws Exception;
}


