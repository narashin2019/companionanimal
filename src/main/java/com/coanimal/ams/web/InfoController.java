package com.coanimal.ams.web;

import java.util.List;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.coanimal.ams.domain.Info;
import com.coanimal.ams.domain.InfoReply;
import com.coanimal.ams.domain.PageMaker;
import com.coanimal.ams.domain.SearchCriteria;
import com.coanimal.ams.service.InfoReplyService;
import com.coanimal.ams.service.InfoService;

@Controller
@RequestMapping("/info")
public class InfoController {

  static Logger logger = LogManager.getLogger(InfoController.class);

  @Autowired
  InfoService infoService;

  @Autowired
  InfoReplyService infoReplyService;
  
  public InfoController() {
    logger.debug("InfoController 생성됨!");
  }

  // 게시글 추가 폼
  @GetMapping("form")
  public void form() throws Exception {}

  // 게시글 추가
  @PostMapping("add")
  public String add(Info info) throws Exception {
    infoService.add(info);
    return "redirect:detail?infoNo=" + info.getInfoNo();
  }

  // 게시글 삭제
  @GetMapping("delete")
  public String delete(int infoNo, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception {
    infoService.delete(infoNo);
    
    rttr.addAttribute("page", scri.getPage());
    rttr.addAttribute("perPageNum", scri.getPerPageNum());
    rttr.addAttribute("searchType", scri.getSearchType());
    rttr.addAttribute("keyword", scri.getKeyword());
    
    return "redirect:list";
  }

  // 게시글 상세보기
  @GetMapping("detail")
  public void detail(int infoNo, Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
    model.addAttribute("detail", infoService.get(infoNo));
    model.addAttribute("scri", scri);
    
    //댓글 조회
    List<InfoReply> replyList = infoReplyService.readReply(infoNo);
    model.addAttribute("replyList", replyList);
  }

  // 리스트 + 페이징
  @GetMapping("list")
  public void list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {

    model.addAttribute("list", infoService.list(scri)); // 게시판의 글 리스트
    
    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(scri);
    pageMaker.setTotalCount(infoService.countInfoListTotal(scri));
    
    model.addAttribute("pageMaker", pageMaker); // 게시판 하단의 페이징 관련, 이전페이지, 페이지 링크 , 다음 페이지
  }

  // 게시글 수정 폼
  @GetMapping("updateForm")
  public void updateForm(int infoNo, Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
    model.addAttribute("update", infoService.get(infoNo));
    model.addAttribute("scri", scri);
  }

  // 게시글 수정
  @PostMapping("update")
  public String update(Info info, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception {
    
    logger.info("update");
   
    infoService.update(info); 
    
    rttr.addAttribute("page", scri.getPage());
    rttr.addAttribute("perPageNum", scri.getPerPageNum());
    rttr.addAttribute("searchType", scri.getSearchType());
    rttr.addAttribute("keyword", scri.getKeyword());
    
    return "redirect:detail?infoNo=" + info.getInfoNo();
  }
  
//  @GetMapping("search")
//  public void search(String keyword, Model model) throws Exception {
//    model.addAttribute("list", infoService.search(keyword));
//  }

  
  //
  // 댓글 작성
  @RequestMapping(value="/replyWrite", method = RequestMethod.POST)
  public String replyWrite(InfoReply infoReply, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
      
      infoReplyService.writeReply(infoReply);
      
      rttr.addAttribute("infoNo", infoReply.getInfoNo());
      rttr.addAttribute("page", scri.getPage());
      rttr.addAttribute("perPageNum", scri.getPerPageNum());
      rttr.addAttribute("searchType", scri.getSearchType());
      rttr.addAttribute("keyword", scri.getKeyword());
      
      return "redirect:detail?infoNo=" + infoReply.getInfoNo();
  }
  
  // 댓글 수정 GET
  @RequestMapping(value = "/replyUpdateView", method = RequestMethod.GET)
  public void replyUpdateView(InfoReply infoReply, Model model, SearchCriteria scri) throws Exception {
    model.addAttribute("replyUpdate", infoReplyService.selectReply(infoReply.getInfoReplyNo()));
    model.addAttribute("scri", scri);
  }
  
  // 댓글 수정 POST
  @RequestMapping(value="/replyUpdate", method = RequestMethod.POST)
  public String replyUpdate(InfoReply infoReply, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
      
      infoReplyService.updateReply(infoReply);
      
      rttr.addAttribute("infoNo", infoReply.getInfoNo());
      rttr.addAttribute("page", scri.getPage());
      rttr.addAttribute("perPageNum", scri.getPerPageNum());
      rttr.addAttribute("searchType", scri.getSearchType());
      rttr.addAttribute("keyword", scri.getKeyword());
      
      return "redirect:detail";
  }
  
  // 댓글 삭제 GET
  @RequestMapping(value="/replyDeleteView", method = RequestMethod.GET)
  public void replyDeleteView(InfoReply infoReply, SearchCriteria scri, Model model) throws Exception {
      
      model.addAttribute("replyDelete", infoReplyService.selectReply(infoReply.getInfoReplyNo()));
      model.addAttribute("scri", scri);
      
  }
  
  // 댓글 삭제 POST
  @RequestMapping(value="/replyDelete", method = RequestMethod.POST)
  public String replyDelete(InfoReply infoReply, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
      
      infoReplyService.deleteReply(infoReply);
      
      rttr.addAttribute("infoNo", infoReply.getInfoNo());
      rttr.addAttribute("page", scri.getPage());
      rttr.addAttribute("perPageNum", scri.getPerPageNum());
      rttr.addAttribute("searchType", scri.getSearchType());
      rttr.addAttribute("keyword", scri.getKeyword());
      
      return "redirect:detail";
  }
  
  
}
