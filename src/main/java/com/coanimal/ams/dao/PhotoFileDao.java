package com.coanimal.ams.dao;

import java.util.List;
import com.coanimal.ams.domain.PhotoBoard;
import com.coanimal.ams.domain.PhotoFile;

public interface PhotoFileDao {
  int insert(PhotoBoard photoBoard) throws Exception;

  List<PhotoFile> findAll(int boardNo) throws Exception;

  int deleteAll(int boardNo) throws Exception;
}


