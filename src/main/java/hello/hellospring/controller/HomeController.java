package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/") //localhost8080에 접속시 호출됨
  public String home(){
    return "home";
  }
}
