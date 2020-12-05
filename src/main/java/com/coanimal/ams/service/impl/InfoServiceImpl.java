package com.coanimal.ams.service.impl;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import com.coanimal.ams.dao.InfoDao;
import com.coanimal.ams.domain.Info;
import com.coanimal.ams.domain.SearchCriteria;
import com.coanimal.ams.service.InfoService;

@Component
public class InfoServiceImpl implements InfoService {

  TransactionTemplate transactionTemplate;
  InfoDao infoDao;
  
  public InfoServiceImpl(PlatformTransactionManager txManager, InfoDao infoDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.infoDao = infoDao;
  }

  @Transactional
  @Override
  public void add(Info info) throws Exception {
    infoDao.insert(info);
  }

  // 리스트 + 검색 + 페이징
  @Override
  public List<Info> list(SearchCriteria scri) throws Exception {
    return infoDao.findAll(scri);
  }
  
  // 리스트 + 검색 + 페이징 (게시물 총 개수 구하기)
  public int countInfoListTotal(SearchCriteria scri) throws Exception {
    return infoDao.countInfoList(scri);
  }

  @Override
  public void delete(int infoNo) throws Exception {
    infoDao.delete(infoNo);
  }

  @Override
  public void update(Info info) throws Exception {
    infoDao.update(info);
  }

  @Override
  public Info get(int infoNo) throws Exception {
    return infoDao.findByNo(infoNo);
  }



//  @Override
//  public List<Info> search(String keyword) throws Exception {
//    return infoDao.findByKeyword(keyword);
//  }


}
