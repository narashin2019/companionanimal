package com.coanimal.ams.dao;

import java.util.List;
import com.coanimal.ams.domain.Info;

// 데이터를 저장하고 꺼내는 방식(파일, 클라우드저장소, DB 등)에 상관없이
// DAO 사용법을 통일하기 위해
// 메서드 호출 규칙을 정의한다.
//
public interface InfoDao {
  public int insert(Info info) throws Exception;

  public List<Info> findAll() throws Exception;

  public Info findByNo(int infoNo) throws Exception;

  public int update(Info info) throws Exception;

  public int delete(int infoNo) throws Exception;
  
  //키워드 검색
  public List<Info> findByKeyword(String keyword) throws Exception;

}


 