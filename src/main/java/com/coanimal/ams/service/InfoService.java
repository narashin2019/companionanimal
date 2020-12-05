package com.coanimal.ams.service;

import java.util.List;
import com.coanimal.ams.domain.Info;

public interface InfoService {

  void add(Info info) throws Exception;

  List<Info> list() throws Exception;

  int delete(int infoNo) throws Exception;

  Info get(int infoNo) throws Exception;

  int update(Info info) throws Exception;
  
  // 키워드 검색
  List<Info> search(String keyword) throws Exception;

}
