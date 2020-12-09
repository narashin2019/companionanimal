package com.coanimal.ams.service;

import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.coanimal.ams.domain.Info;
import com.coanimal.ams.domain.SearchCriteria;

public interface InfoService {

  // 게시글 작성 + 첨부파일 업로드
  void add(Info info, MultipartHttpServletRequest mpRequest) throws Exception;

  // 리스트 + 검색 + 페이징
  List<Info> list(SearchCriteria scri) throws Exception;

  // 리스트 + 검색 + 페이징 (게시물 총 개수 구하기)
  int countInfoListTotal(SearchCriteria scri) throws Exception;

  void delete(int infoNo) throws Exception;

  Info get(int infoNo) throws Exception;

  void update(Info info) throws Exception;

  //List<Info> search(String keyword) throws Exception;

  // 첨부파일 조회
  public List<Map<String, Object>> selectFileList(int infoNo) throws Exception;
  
  //첨부파일 다운
  public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
}
