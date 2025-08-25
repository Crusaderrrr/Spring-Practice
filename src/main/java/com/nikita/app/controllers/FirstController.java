package com.nikita.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

  @GetMapping("/hello")
  public String helloPage(@RequestParam("a") int a,
                          @RequestParam("b") int b,
                          @RequestParam("action") String action,
                          Model model) {
      int res;
      switch (action) {
          case "mult": res = a * b; break;
          case "div": res = a / b; break;
          case "sum": res = a + b; break;
          case "sub": res = a - b; break;
          default: res = 0; break;
      }
      model.addAttribute("response", res);
      return "first/hello";
  }

  @GetMapping("/goodbye")
  public String goodbyePage() {
    return "first/goodbye";
  }
}
