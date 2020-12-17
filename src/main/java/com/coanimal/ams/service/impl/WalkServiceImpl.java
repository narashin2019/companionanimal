package com.coanimal.ams.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.coanimal.ams.dao.WalkDao;
import com.coanimal.ams.domain.SearchCriteria;
import com.coanimal.ams.domain.Walk;
import com.coanimal.ams.service.WalkService;
import com.coanimal.ams.util.FileUtils;

@Component
public class WalkServiceImpl implements WalkService {

  //첨부파일 관련
  @Resource(name="fileUtils")
  private FileUtils fileUtils;

  TransactionTemplate transactionTemplate;
  WalkDao walkDao;

  public WalkServiceImpl(PlatformTransactionManager txManager, WalkDao walkDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.walkDao = walkDao;
  }

  @Transactional
  @Override // 게시글 작성 + 첨부파일 업로드
  public void add(Walk walk, MultipartHttpServletRequest mpRequest) throws Exception {
    walkDao.insert(walk);

    List<Map<String,Object>> list = fileUtils.parseInsertFileWalk(walk, mpRequest);
    int size = list.size();
    for(int i=0; i<size; i++){
      walkDao.insertFile(list.get(i));
    }

  }

  // 리스트 + 검색 + 페이징
  @Override
  public List<Walk> list(SearchCriteria scri) throws Exception {
    return walkDao.findAll(scri);
  }

  // 리스트 + 검색 + 페이징 (게시물 총 개수 구하기)
  @Override
  public int countWalkListTotal(SearchCriteria scri) throws Exception {
    return walkDao.countWalkList(scri);
  }

  @Override
  public void delete(int walkNo) throws Exception {
    walkDao.delete(walkNo);
  }

  // 게시뭉 수정 + 첨부파일 수정
  @Transactional
  @Override
  public void update(Walk walk, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception {
    walkDao.update(walk);

    List<Map<String, Object>> list = fileUtils.parseUpdateFileWalk(walk, files, fileNames, mpRequest);
    Map<String, Object> tempMap = null;

    int size = list.size();
    for(int i = 0; i<size; i++) {
      tempMap = list.get(i);
      if(tempMap.get("IS_NEW").equals("1")) {
        walkDao.insertFile(tempMap);
      }else {
        walkDao.updateFile(tempMap);
      }
    }
  }

  // 게시물 조회 + 조회수 카운트
  @Override
  public Walk get(int walkNo) throws Exception {
    walkDao.plusCnt(walkNo);
    return walkDao.findByNo(walkNo);
  }



  //  @Override
  //  public List<Info> search(String keyword) throws Exception {
  //    return infoDao.findByKeyword(keyword);
  //  }


  // 첨부파일 조회
  @Override
  public List<Map<String, Object>> selectFileList(int walkNo) throws Exception {
    return walkDao.selectFileList(walkNo);
  }

  // 첨부파일 다운로드
  @Override
  public Map<String, Object> selectFileWalk(Map<String, Object> map) throws Exception {
    return walkDao.selectFileWalk(map);
  }



}