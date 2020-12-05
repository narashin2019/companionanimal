
package com.coanimal.ams.service;

import java.util.List;
import com.coanimal.ams.domain.Criteria;
import com.coanimal.ams.domain.Walk;

public interface WalkService {

  void add(Walk walk) throws Exception;

  List<Walk> list(Criteria cri) throws Exception;

  int delete(int walkNo) throws Exception;

  Walk get(int walkNo) throws Exception;

  int update(Walk walk) throws Exception;

  // 키워드 검색
  List<Walk> search(String keyword) throws Exception;

  // 게시물 총 개수 구하기
  int countWalkListTotal() throws Exception;

}