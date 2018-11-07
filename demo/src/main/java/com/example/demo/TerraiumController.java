package com.example.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class TerraiumController {

    /**
     * recuperer tous les parametres de terraium
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)

    public String hello() {
      return "hello";

    }

}


