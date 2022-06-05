package com.nuchange.urltraker.service.impl;

import com.nuchange.urltraker.model.UrlCountlModel;
import com.nuchange.urltraker.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UrlServiceImpl implements UrlService {

  private static Map<String, Integer> urlMap = new HashMap<>();
  private static List<UrlCountlModel> urlList = new ArrayList<>();

  @Override
  public ResponseEntity saveUrl(String url) {
    if(!url.contains(".")){
      return new ResponseEntity("Invalid request parameter url",HttpStatus.BAD_REQUEST);
    }
    synchronized (urlMap) {
      String[] urlArray = url.split("[.]");
      if (urlMap.containsKey(urlArray[0])) {
        urlMap.put(urlArray[0], urlMap.get(urlArray[0]) + 1);
      } else {
        urlMap.put(urlArray[0], 0);
      }
      return new ResponseEntity(HttpStatus.OK);
    }
  }

  @Override
  public String getUrl(String url) {
    if(!url.contains(".")){
      return "Invalid request parameter url";
    }
    synchronized (urlMap) {
      String[] urlArray = url.split("[.]");
      if (urlMap.containsKey(urlArray[0])) {
        urlMap.put(urlArray[0], urlMap.get(urlArray[0]) + 1);
      } else {
        urlMap.put(urlArray[0], 0);
      }
      return urlArray[0];
    }
  }

  @Override
  public int getCount(String url) {
    if(!url.contains(".")){
      return 0;
    }
    String[] urlArray = url.split("[.]");
    if (urlMap.get(urlArray[0]) == null) {
      return 0;
    }
    return urlMap.get(urlArray[0]);
  }

  @Override
  public List<UrlCountlModel> getAllUrls() {
    List<UrlCountlModel> urlList = new ArrayList<>();
    for(Map.Entry<String,Integer> entry : urlMap.entrySet()){
      UrlCountlModel model = new UrlCountlModel(entry.getKey(), entry.getValue());
      urlList.add(model);
    }
    return urlList;
  }

}
