package com.example.model.service;

import com.example.model.resources.base.info.SiteInfo;
import com.example.model.resources.util.FileUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class SiteService {
    private final String resourceFileName = "config-sites.json";
    private final String storagePath;
    private final Gson gson;

    public SiteService(@Value("${storage.path}") String storagePath, Gson gson) {
        this.storagePath = storagePath;
        this.gson = gson;
    }

    public SiteInfo findByShopCode(String shopCode) throws IOException {
        String filePath = Paths.get(storagePath,resourceFileName).toString();

        String jsonContent = FileUtil.readFile(filePath);
        SiteInfo[] infos = gson.fromJson(jsonContent, SiteInfo[].class);

        for (SiteInfo info : infos) {
            if(info.getShopCode().equals(shopCode)){
                return info;
            }
        }

        //Return default shop English Blue
        return findByShopCode("enbl");
    }
}
