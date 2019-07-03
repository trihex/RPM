package com.trihex.rpm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AngularController {

  @RequestMapping({"/login", "/validate", "/admin"})
  public String loginHandling() {
    return "forward:/index.html";
  }
}
