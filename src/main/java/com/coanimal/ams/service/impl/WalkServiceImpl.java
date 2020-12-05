package com.coanimal.ams.service.impl;

import java.util.List;
import org.springframework.stereotype.Component;
import com.coanimal.ams.dao.WalkDao;
import com.coanimal.ams.domain.Walk;
import com.coanimal.ams.service.WalkService;

@Component
public class WalkServiceImpl implements WalkService {

  WalkDao walkDao;



  public WalkServiceImpl(WalkDao walkDao) {
    this.walkDao = walkDao;
  }

  @Override
  public void add(Walk walk) throws Exception {
    walkDao.insert(walk);
  }

  @Override
  public List<Walk> list() throws Exception {
    return walkDao.findAll();
  }

  @Override
  public int delete(int walkNo) throws Exception {
    return walkDao.delete(walkNo);
  }

  @Override
  public int update(Walk walk) throws Exception {
    return walkDao.update(walk);
  }

  @Override
  public Walk get(int walkNo) throws Exception {
    return walkDao.findByNo(walkNo);
  }

}
