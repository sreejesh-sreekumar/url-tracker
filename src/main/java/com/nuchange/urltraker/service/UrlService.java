package com.nuchange.urltraker.service;

import com.nuchange.urltraker.model.UrlCountlModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UrlService {
    public ResponseEntity saveUrl(String url);

    public String getUrl(String url);

    public int getCount(String url);

    public List<UrlCountlModel> getAllUrls();
}
