package com.coanimal.ams.web;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.coanimal.ams.domain.Info;
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
  public void detail(int infoNo, Model model) throws Exception {
    model.addAttribute("info", infoService.get(infoNo));
  }

  @GetMapping("list")
  public void list(Model model) throws Exception {
    System.out.println("리스트 호출되었음");
    List<Info> infos = infoService.list();
    model.addAttribute("list", infos);
  }

  @GetMapping("updateForm")
  public void updateForm(int infoNo, Model model) throws Exception {
    model.addAttribute("info", infoService.get(infoNo));
  }

  @PostMapping("update")
  public String update(Info info) throws Exception {
    infoService.update(info);
    return "redirect:list";
  }
}
