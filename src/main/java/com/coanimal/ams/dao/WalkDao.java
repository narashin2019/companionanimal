package com.coanimal.ams.dao;

import java.util.List;
import java.util.Map;
import com.coanimal.ams.domain.SearchCriteria;
import com.coanimal.ams.domain.Walk;

// 데이터를 저장하고 꺼내는 방식(파일, 클라우드저장소, DB 등)에 상관없이
// DAO 사용법을 통일하기 위해
// 메서드 호출 규칙을 정의한다.
//
public interface WalkDao {
  public int insert(Walk walk) throws Exception;

  // 리스트 + 검색 + 페이징
  public List<Walk> findAll(SearchCriteria scri) throws Exception;

  // 리스트 + 검색 + 페이징 (총 게시글 갯수 구하기)
  public int countWalkList(SearchCriteria scri) throws Exception;

  public Walk findByNo(int walkNo) throws Exception;

  public int update(Walk walk) throws Exception;

  public int delete(int walkNo) throws Exception;

  //public List<Walk> findByKeyword(String keyword) throws Exception;

  // 첨부파일 업로드
  public void insertFile(Map<String, Object> map) throws Exception;

  // 첨부파일 조회
  public List<Map<String, Object>> selectFileList(int walkNo) throws Exception;

  // 첨부파일 다운로드
  public Map<String, Object> selectFileWalk(Map<String, Object> map) throws Exception;

  // 첨부파일 수정
  public void updateFile(Map<String, Object> map) throws Exception;

  // 게시물 조회수
  public void plusCnt(int walkNo) throws Exception;
}
