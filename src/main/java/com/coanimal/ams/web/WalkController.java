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
import com.coanimal.ams.domain.PageMaker;
import com.coanimal.ams.domain.SearchCriteria;
import com.coanimal.ams.domain.Walk;
import com.coanimal.ams.service.WalkService;

@Controller
@RequestMapping("/walk")
public class WalkController {

  static Logger logger = LogManager.getLogger(WalkController.class);

  @Autowired
  WalkService walkService;

  public WalkController() {
    logger.debug("WalkController 생성됨!");
  }

  @GetMapping("form")
  public void form() throws Exception {}

  @PostMapping("add")
  public String add(Walk walk) throws Exception {
    walkService.add(walk);
    return "redirect:detail?walkNo=" + walk.getWalkNo();
  }

  @GetMapping("delete")
  public String delete(int walkNo) throws Exception {
    if (walkService.delete(walkNo) > 0) {
      return "redirect:list";
    } else {
      throw new Exception("삭제할 게시물 번호가 유효하지 않습니다.");
    }
  }

  @GetMapping("detail")
  public void detail(int walkNo, Model model, Criteria cri) throws Exception {
    model.addAttribute("walk", walkService.get(walkNo));

    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(cri);

    model.addAttribute("page", cri.getPage());
    model.addAttribute("PageMaker", pageMaker);
  }

  // 리스트 + 페이징
  @GetMapping("list")
  public void list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {

    model.addAttribute("list", walkService.list(scri)); // 게시판의 글 리스트

    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(scri);
    pageMaker.setTotalCount(walkService.countWalkListTotal(scri));

    model.addAttribute("pageMaker", pageMaker); // 게시판 하단의 페이징 관련, 이전페이지, 페이지 링크, 다음 페이지
  }

  @GetMapping("updateForm")
  public void updateForm(int walkNo, Model model) throws Exception {
    model.addAttribute("walk", walkService.get(walkNo));
  }

  @PostMapping("update")
  public String update(Walk walk) throws Exception {

    logger.info("update");

    walkService.update(walk);
    return "redirect:detail?walkNo=" + walk.getWalkNo();
  }

  //  @GetMapping("search")
  //  public void search(String keyword, Model model) throws Exception {
  //    model.addAttribute("list", walkService.search(keyword));
  //  }
}
