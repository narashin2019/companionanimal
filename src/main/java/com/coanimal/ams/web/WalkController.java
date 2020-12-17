package com.coanimal.ams.web;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.coanimal.ams.domain.PageMaker;
import com.coanimal.ams.domain.SearchCriteria;
import com.coanimal.ams.domain.Walk;
import com.coanimal.ams.domain.WalkReply;
import com.coanimal.ams.service.WalkReplyService;
import com.coanimal.ams.service.WalkService;

@Controller
@RequestMapping("/walk")
public class WalkController {

  static Logger logger = LogManager.getLogger(WalkController.class);
  @Autowired
  WalkService walkService;

  @Autowired
  WalkReplyService walkReplyService;

  public WalkController() {
    logger.debug("WalkController 생성됨!");
  }

  // 게시글 추가 폼
  @GetMapping("form")
  public void form() throws Exception {}

  // 게시글 추가 + 첨부파일 업로드
  @PostMapping("add")
  public String add(Walk walk, MultipartHttpServletRequest mpRequest) throws Exception {
    walkService.add(walk, mpRequest);
    return "redirect:detail?walkNo=" + walk.getWalkNo();
  }

  // 게시글 삭제
  @GetMapping("delete")
  public String delete(int walkNo, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception {
    walkService.delete(walkNo);

    rttr.addAttribute("page", scri.getPage());
    rttr.addAttribute("perPageNum", scri.getPerPageNum());
    rttr.addAttribute("searchType", scri.getSearchType());
    rttr.addAttribute("keyword", scri.getKeyword());

    return "redirect:list";
  }

  // 게시글 상세보기
  @GetMapping("detail")
  public void detail(int walkNo, Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
    model.addAttribute("detail", walkService.get(walkNo));
    model.addAttribute("scri", scri);

    // 댓글 조회
    List<WalkReply> replyList = walkReplyService.readReply(walkNo);
    model.addAttribute("replyList", replyList);

    // 첨부파일 조회
    List<Map<String, Object>> fileList = walkService.selectFileList(walkNo);
    model.addAttribute("file", fileList);
  }

  // 리스트 + 페이징
  @GetMapping("list")
  public void list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {

    model.addAttribute("list", walkService.list(scri)); // 게시판의 글 리스트

    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(scri);
    pageMaker.setTotalCount(walkService.countWalkListTotal(scri));

    model.addAttribute("pageMaker", pageMaker); // 게시판 하단의 페이징 관련, 이전페이지, 페이지 링크 , 다음 페이지
  }

  // 게시글 수정 폼
  @GetMapping("updateForm")
  public void updateForm(int walkNo, Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
    model.addAttribute("update", walkService.get(walkNo));
    model.addAttribute("scri", scri);

    // 첨부파일 수정
    List<Map<String, Object>> fileList = walkService.selectFileList(walkNo);
    model.addAttribute("file", fileList);
    System.out.println("파일리스트에 담긴것 확인");
    System.out.println(fileList);
  }

  // 게시글 수정 + 첨부파일 수정
  @PostMapping("update")
  public String update(Walk walk, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr,
      @RequestParam(value="fileNoDel[]") String[] files,
      @RequestParam(value="fileNameDel[]") String[] fileNames,
      MultipartHttpServletRequest mpRequest) throws Exception {

    logger.info("update");

    walkService.update(walk, files, fileNames, mpRequest);
    System.out.println("파일스 파일네임스 jsp에서 받아왔나 확인");
    System.out.println(files);
    System.out.println(fileNames);

    rttr.addAttribute("page", scri.getPage());
    rttr.addAttribute("perPageNum", scri.getPerPageNum());
    rttr.addAttribute("searchType", scri.getSearchType());
    rttr.addAttribute("keyword", scri.getKeyword());

    return "redirect:detail?walkNo=" + walk.getWalkNo();
  }

  //  @GetMapping("search")
  //  public void search(String keyword, Model model) throws Exception {
  //    model.addAttribute("list", walkService.search(keyword));
  //  }

  // 댓글 작성
  @RequestMapping(value="/replyWrite", method = RequestMethod.POST)
  public String replyWrite(WalkReply walkReply, SearchCriteria scri, RedirectAttributes rttr) throws Exception {

    walkReplyService.writeReply(walkReply);

    rttr.addAttribute("walkNo", walkReply.getWalkNo());
    rttr.addAttribute("page", scri.getPage());
    rttr.addAttribute("perPageNum", scri.getPerPageNum());
    rttr.addAttribute("searchType", scri.getSearchType());
    rttr.addAttribute("keyword", scri.getKeyword());

    return "redirect:detail?walkNo=" + walkReply.getWalkNo();
  }

  // 댓글 수정 GET
  @RequestMapping(value = "/replyUpdateView", method = RequestMethod.GET)
  public void replyUpdateView(WalkReply walkReply, Model model, SearchCriteria scri) throws Exception {
    model.addAttribute("replyUpdate", walkReplyService.selectReply(walkReply.getWalkReplyNo()));
    model.addAttribute("scri", scri);
  }

  // 댓글 수정 POST
  @RequestMapping(value="/replyUpdate", method = RequestMethod.POST)
  public String replyUpdate(WalkReply walkReply, SearchCriteria scri, RedirectAttributes rttr) throws Exception {

    walkReplyService.updateReply(walkReply);

    rttr.addAttribute("walkNo", walkReply.getWalkNo());
    rttr.addAttribute("page", scri.getPage());
    rttr.addAttribute("perPageNum", scri.getPerPageNum());
    rttr.addAttribute("searchType", scri.getSearchType());
    rttr.addAttribute("keyword", scri.getKeyword());

    return "redirect:detail";
  }

  // 댓글 삭제 GET
  @RequestMapping(value="/replyDeleteView", method = RequestMethod.GET)
  public void replyDeleteView(WalkReply walkReply, SearchCriteria scri, Model model) throws Exception {

    model.addAttribute("replyDelete", walkReplyService.selectReply(walkReply.getWalkReplyNo()));
    model.addAttribute("scri", scri);

  }

  // 댓글 삭제 POST
  @RequestMapping(value="/replyDelete", method = RequestMethod.POST)
  public String replyDelete(WalkReply walkReply, SearchCriteria scri, RedirectAttributes rttr) throws Exception {

    walkReplyService.deleteReply(walkReply);

    rttr.addAttribute("walkNo", walkReply.getWalkNo());
    rttr.addAttribute("page", scri.getPage());
    rttr.addAttribute("perPageNum", scri.getPerPageNum());
    rttr.addAttribute("searchType", scri.getSearchType());
    rttr.addAttribute("keyword", scri.getKeyword());

    return "redirect:detail";
  }

  // 첨부파일 다운로드
  @RequestMapping(value="/fileDown")
  public void fileDown(@RequestParam Map<String, Object> map, HttpServletResponse response) throws Exception{
    Map<String, Object> resultMap = walkService.selectFileWalk(map);
    String storedFileName = (String) resultMap.get("stored_file_name");
    String originalFileName = (String) resultMap.get("org_file_name");

    // 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
    byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\coanimal\\file\\"+storedFileName));

    response.setContentType("application/octet-stream");
    response.setContentLength(fileByte.length);
    response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originalFileName, "UTF-8")+"\";");
    response.getOutputStream().write(fileByte);
    response.getOutputStream().flush();
    response.getOutputStream().close();

  }
}