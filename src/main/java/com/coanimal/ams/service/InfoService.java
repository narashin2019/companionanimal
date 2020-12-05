package com.coanimal.ams.service;

import java.util.List;
import com.coanimal.ams.domain.Criteria;
import com.coanimal.ams.domain.Info;
import com.coanimal.ams.domain.SearchCriteria;

public interface InfoService {

  void add(Info info) throws Exception;

  List<Info> list(SearchCriteria scri) throws Exception;

  int delete(int infoNo) throws Exception;

  Info get(int infoNo) throws Exception;

  int update(Info info) throws Exception;

  // 키워드 검색
  List<Info> search(String keyword) throws Exception;

  // 게시물 총 개수 구하기
  int countInfoListTotal(SearchCriteria scri) throws Exception;

}
