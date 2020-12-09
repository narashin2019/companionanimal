package com.coanimal.ams.dao;

import java.util.List;
import java.util.Map;
import com.coanimal.ams.domain.Info;
import com.coanimal.ams.domain.SearchCriteria;

// 데이터를 저장하고 꺼내는 방식(파일, 클라우드저장소, DB 등)에 상관없이
// DAO 사용법을 통일하기 위해
// 메서드 호출 규칙을 정의한다.
//
public interface InfoDao {
  public int insert(Info info) throws Exception;

  // 리스트 + 검색 + 페이징
  public List<Info> findAll(SearchCriteria scri) throws Exception;
  
  // 리스트 + 검색 + 페이징 (총 게시글 갯수 구하기)
  public int countInfoList(SearchCriteria scri) throws Exception;

  public Info findByNo(int infoNo) throws Exception;

  public int update(Info info) throws Exception;

  public int delete(int infoNo) throws Exception;
  
  //public List<Info> findByKeyword(String keyword) throws Exception;
  
  //첨부파일 업로드
  public void insertFile(Map<String, Object> map) throws Exception;
  


}


 