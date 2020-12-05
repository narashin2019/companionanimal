package com.coanimal.ams.service;

import java.util.List;
import com.coanimal.ams.domain.Info;
import com.coanimal.ams.domain.SearchCriteria;

public interface InfoService {

  void add(Info info) throws Exception;

  // 리스트 + 검색 + 페이징
  List<Info> list(SearchCriteria scri) throws Exception;

  // 리스트 + 검색 + 페이징 (게시물 총 개수 구하기)
  int countInfoListTotal(SearchCriteria scri) throws Exception;

  void delete(int infoNo) throws Exception;

  Info get(int infoNo) throws Exception;

  void update(Info info) throws Exception;

  //List<Info> search(String keyword) throws Exception;


}
