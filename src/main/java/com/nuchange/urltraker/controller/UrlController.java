package com.nuchange.urltraker.controller;

import com.nuchange.urltraker.model.UrlCountlModel;
import com.nuchange.urltraker.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UrlController {

  @Autowired UrlService service;

  @GetMapping("/storeurl")
  public ResponseEntity saveUrl(@RequestParam("url") String url) {
    return service.saveUrl(url);
  }

  @GetMapping("/get")
  public String getUrl(@RequestParam("url") String url) {
    return service.getUrl(url);
  }

  @GetMapping("/count")
  public int getCount(@RequestParam("url") String url) {
    return service.getCount(url);
  }

  @GetMapping("/list")
  public List<UrlCountlModel> getAllUrls(){
    return service.getAllUrls();
  }
}
