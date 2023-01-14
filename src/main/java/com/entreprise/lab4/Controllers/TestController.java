package com.entreprise.lab4.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
   
   @RequestMapping( "/hello" )
   public String echo() {
      return "Hello World!";
   }
}

