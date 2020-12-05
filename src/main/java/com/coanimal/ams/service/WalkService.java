package com.coanimal.ams.service;

import java.util.List;
import com.coanimal.ams.domain.Walk;

public interface WalkService {

  void add(Walk walk) throws Exception;

  List<Walk> list() throws Exception;

  int delete(int walkNo) throws Exception;

  Walk get(int walkNo) throws Exception;

  int update(Walk walk) throws Exception;
}
