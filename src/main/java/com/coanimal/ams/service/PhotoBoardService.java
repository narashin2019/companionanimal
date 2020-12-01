package com.coanimal.ams.service;

import java.util.List;
import com.coanimal.ams.domain.PhotoBoard;

public interface PhotoBoardService {
  void add(PhotoBoard photoBoard) throws Exception;

  List<PhotoBoard> listLessonPhoto(int lessonNo) throws Exception;

  PhotoBoard get(int no) throws Exception;

  void update(PhotoBoard photoBoard) throws Exception;

  void delete(int no) throws Exception;
}
