package com.coanimal.ams.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.coanimal.ams.domain.Info;
import com.coanimal.ams.domain.Walk;

@Component("fileUtils")
public class FileUtils {
  private static final String filePath = "C:\\coanimal\\file\\"; // 파일이 저장될 위치

  public List<Map<String, Object>> parseInsertFileInfo(Info info,
      MultipartHttpServletRequest mpRequest) throws Exception{

    /*
            Iterator은 데이터들의 집합체? 에서 컬렉션으로부터 정보를 얻어올 수 있는 인터페이스입니다.
            List나 배열은 순차적으로 데이터의 접근이 가능하지만, Map등의 클래스들은 순차적으로 접근할 수가 없습니다.
            Iterator을 이용하여 Map에 있는 데이터들을 while문을 이용하여 순차적으로 접근합니다.
     */

    Iterator<String> iterator = mpRequest.getFileNames();

    MultipartFile multipartFile = null;
    String originalFileName = null;
    String originalFileExtension = null;
    String storedFileName = null;

    List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
    Map<String, Object> listMap = null;

    int infoNo = info.getInfoNo();

    File file = new File(filePath);
    if(file.exists() == false) {
      file.mkdirs();
    }

    while(iterator.hasNext()) {
      multipartFile = mpRequest.getFile(iterator.next());
      if(multipartFile.isEmpty() == false) {
        originalFileName = multipartFile.getOriginalFilename();
        originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        storedFileName = getRandomString() + originalFileExtension;

        file = new File(filePath + storedFileName);
        multipartFile.transferTo(file);
        listMap = new HashMap<String, Object>();
        listMap.put("info_no", infoNo);
        listMap.put("org_file_name", originalFileName);
        listMap.put("stored_file_name", storedFileName);
        listMap.put("file_size", multipartFile.getSize());
        list.add(listMap);
      }
    }
    return list;
  }

  public List<Map<String, Object>> parseUpdateFileInfo(Info info, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception{

    Iterator<String> iterator = mpRequest.getFileNames();

    MultipartFile multipartFile = null;
    String originalFileName = null;
    String originalFileExtension = null;
    String storedFileName = null;

    List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
    Map<String, Object> listMap = null;

    int infoNo = info.getInfoNo();

    while(iterator.hasNext()){
      multipartFile = mpRequest.getFile(iterator.next());

      // multipartFile이 비어있지 않으면 if문 실행, 새로운 첨부파일이 등록되었을때
      if (multipartFile.isEmpty() == false) {
        originalFileName = multipartFile.getOriginalFilename();
        originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        storedFileName = getRandomString() + originalFileExtension;
        multipartFile.transferTo(new File(filePath + storedFileName));
        listMap = new HashMap<String,Object>();
        listMap.put("IS_NEW", "1");
        listMap.put("info_no", infoNo);
        listMap.put("org_file_name", originalFileName);
        listMap.put("stored_file_name", storedFileName);
        listMap.put("file_size", multipartFile.getSize());
        list.add(listMap);
      }
    }

    // files와 fileNames가 null이 아니면 for문 실행, 삭제할 파일의 파일 번호와 파일이름을 받음
    if (files != null && fileNames != null) {
      System.out.println("포문이 실행되어야 하는데");
      for(int i = 0; i < fileNames.length; i++) {
        listMap = new HashMap<String,Object>();
        listMap.put("IS_NEW", "0");
        listMap.put("file_no", files[i]);
        list.add(listMap);
        System.out.println(listMap);
      }
    }
    return list;
  }


  public static String getRandomString() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  public List<Map<String, Object>> parseInsertFileWalk(Walk walk,
      MultipartHttpServletRequest mpRequest) throws Exception{

    /*
        Iterator은 데이터들의 집합체? 에서 컬렉션으로부터 정보를 얻어올 수 있는 인터페이스입니다.
        List나 배열은 순차적으로 데이터의 접근이 가능하지만, Map등의 클래스들은 순차적으로 접근할 수가 없습니다.
        Iterator을 이용하여 Map에 있는 데이터들을 while문을 이용하여 순차적으로 접근합니다.
     */

    Iterator<String> iterator = mpRequest.getFileNames();

    MultipartFile multipartFile = null;
    String originalFileName = null;
    String originalFileExtension = null;
    String storedFileName = null;

    List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
    Map<String, Object> listMap = null;

    int walkNo = walk.getWalkNo();

    File file = new File(filePath);
    if(file.exists() == false) {
      file.mkdirs();
    }

    while(iterator.hasNext()) {
      multipartFile = mpRequest.getFile(iterator.next());
      if(multipartFile.isEmpty() == false) {
        originalFileName = multipartFile.getOriginalFilename();
        originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        storedFileName = getRandomString() + originalFileExtension;

        file = new File(filePath + storedFileName);
        multipartFile.transferTo(file);
        listMap = new HashMap<String, Object>();
        listMap.put("walk_no", walkNo);
        listMap.put("org_file_name", originalFileName);
        listMap.put("stored_file_name", storedFileName);
        listMap.put("file_size", multipartFile.getSize());
        list.add(listMap);
      }
    }
    return list;
  }

  public List<Map<String, Object>> parseUpdateFileWalk(Walk walk, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception{

    Iterator<String> iterator = mpRequest.getFileNames();

    MultipartFile multipartFile = null;
    String originalFileName = null;
    String originalFileExtension = null;
    String storedFileName = null;

    List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
    Map<String, Object> listMap = null;

    int walkNo = walk.getWalkNo();

    while(iterator.hasNext()){
      multipartFile = mpRequest.getFile(iterator.next());

      // multipartFile이 비어있지 않으면 if문 실행, 새로운 첨부파일이 등록되었을때
      if (multipartFile.isEmpty() == false) {
        originalFileName = multipartFile.getOriginalFilename();
        originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        storedFileName = getRandomString() + originalFileExtension;
        multipartFile.transferTo(new File(filePath + storedFileName));
        listMap = new HashMap<String,Object>();
        listMap.put("IS_NEW", "1");
        listMap.put("walk_no", walkNo);
        listMap.put("org_file_name", originalFileName);
        listMap.put("stored_file_name", storedFileName);
        listMap.put("file_size", multipartFile.getSize());
        list.add(listMap);
      }
    }

    // files와 fileNames가 null이 아니면 for문 실행, 삭제할 파일의 파일 번호와 파일이름을 받음
    if (files != null && fileNames != null) {
      System.out.println("포문이 실행되어야 하는데");
      for(int i = 0; i < fileNames.length; i++) {
        listMap = new HashMap<String,Object>();
        listMap.put("IS_NEW", "0");
        listMap.put("file_no", files[i]);
        list.add(listMap);
        System.out.println(listMap);
      }
    }
    return list;
  }

}