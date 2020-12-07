package com.coanimal.ams.service.impl;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import com.coanimal.ams.dao.WalkDao;
import com.coanimal.ams.domain.SearchCriteria;
import com.coanimal.ams.domain.Walk;
import com.coanimal.ams.service.WalkService;

@Component
public class WalkServiceImpl implements WalkService {

  TransactionTemplate transactionTemplate;
  WalkDao walkDao;

  public WalkServiceImpl(PlatformTransactionManager txManager, WalkDao walkDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.walkDao = walkDao;
  }

  @Transactional
  @Override
  public void add(Walk walk) throws Exception {
    walkDao.insert(walk);
  }

  @Override
  public List<Walk> list(SearchCriteria scri) throws Exception {
    return walkDao.findAll(scri);
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

  // 게시물 총 개수 구하기
  @Override
  public int countWalkListTotal(SearchCriteria scri) throws Exception {
    return walkDao.countWalkList(scri);
  }

  //  @Override
  //  public List<Walk> search(String keyword) throws Exception {
  //    return walkDao.findByKeyword(keyword);
  //  }


}
