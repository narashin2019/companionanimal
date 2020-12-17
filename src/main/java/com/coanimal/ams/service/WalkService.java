package com.coanimal.ams.service;

import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.coanimal.ams.domain.SearchCriteria;
import com.coanimal.ams.domain.Walk;

public interface WalkService {

  // 게시글 작성 + 첨부파일 업로드
  void add(Walk walk, MultipartHttpServletRequest mpRequest) throws Exception;

  // 리스트 + 검색 + 페이징
  List<Walk> list(SearchCriteria scri) throws Exception;

  // 리스트 + 검색 + 페이징 (게시물 총 개수 구하기)
  int countWalkListTotal(SearchCriteria scri) throws Exception;

  void delete(int walkNo) throws Exception;

  Walk get(int walkNo) throws Exception;

  // 게시글 수정 + 첨부파일 수정
  void update(Walk walk, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception;

  //List<Info> search(String keyword) throws Exception;

  // 첨부파일 조회
  public List<Map<String, Object>> selectFileList(int walkNo) throws Exception;

  // 첨부파일 다운로드
  public Map<String, Object> selectFileWalk(Map<String, Object> map) throws Exception;
}
