package com.coanimal.ams.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.coanimal.ams.domain.Criteria;
import com.coanimal.ams.domain.Info;
import com.coanimal.ams.domain.PageMaker;
import com.coanimal.ams.domain.SearchCriteria;
import com.coanimal.ams.service.InfoService;

@Controller
@RequestMapping("/info")
public class InfoController {

  static Logger logger = LogManager.getLogger(InfoController.class);

  @Autowired
  InfoService infoService;

  public InfoController() {
    logger.debug("InfoController 생성됨!");
  }

  @GetMapping("form")
  public void form() throws Exception {}

  @PostMapping("add")
  public String add(Info info) throws Exception {
    infoService.add(info);
    return "redirect:detail?infoNo=" + info.getInfoNo();
  }

  @GetMapping("delete")
  public String delete(int infoNo) throws Exception {
    if (infoService.delete(infoNo) > 0) {
      return "redirect:list";
    } else {
      throw new Exception("삭제할 게시물 번호가 유효하지 않습니다.");
    }
  }

  @GetMapping("detail")
  public void detail(int infoNo, Model model, Criteria cri) throws Exception {
    model.addAttribute("info", infoService.get(infoNo));

    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(cri);

    model.addAttribute("page", cri.getPage());
    model.addAttribute("PageMaker", pageMaker);

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

  @GetMapping("updateForm")
  public void updateForm(int infoNo, Model model) throws Exception {
    model.addAttribute("info", infoService.get(infoNo));
  }

  @PostMapping("update")
  public String update(Info info) throws Exception {

    logger.info("update");

    infoService.update(info);
    return "redirect:detail?infoNo=" + info.getInfoNo();
  }

  @GetMapping("search")
  public void search(String keyword, Model model) throws Exception {
    model.addAttribute("list", infoService.search(keyword));
  }


}
