package com.coanimal.ams.web;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.coanimal.ams.domain.Criteria;
import com.coanimal.ams.domain.PageMaker;
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
  public void detail(int walkNo, Model model) throws Exception {
    model.addAttribute("walk", walkService.get(walkNo));
  }

  @GetMapping("list")
  public void list(Model model, Criteria cri) throws Exception {

    model.addAttribute("list", walkService.list(cri));

    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(cri);
    pageMaker.setTotalCount(walkService.countWalkListTotal());

    model.addAttribute("pageMaker", pageMaker);
  }

  @GetMapping("updateForm")
  public void updateForm(int walkNo, Model model) throws Exception {
    model.addAttribute("walk", walkService.get(walkNo));
  }

  @PostMapping("update")
  public String update(Walk walk) throws Exception {
    walkService.update(walk);
    return "redirect:list";
  }

  @GetMapping("search")
  public void search(String keyword, Model model) throws Exception {
    model.addAttribute("list", walkService.search(keyword));
  }
}
