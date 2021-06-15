package com.example.model.service;

import com.example.model.resources.base.ShopResource;
import com.example.model.resources.base.info.SiteInfo;
import com.example.model.resources.base.resource.Resource;
import com.example.model.resources.util.FileUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Component
public class ResourceService {

    private final String resourceFileName = "config-resources.json";
    private final String storagePath;
    private final Gson gson;

    public ResourceService(@Value("${storage.path}") String storagePath, Gson gson) {
        this.storagePath = storagePath;
        this.gson = gson;
    }

    public Resource findByName(String resourceName) throws IOException {
        String filePath = Paths.get(storagePath,resourceFileName).toString();

        String jsonContent = FileUtil.readFile(filePath);
        Resource[] resources = gson.fromJson(jsonContent, Resource[].class);

        for (Resource resource : resources) {
            if(resource.getName().equals(resourceName)){
                return resource;
            }
        }
        throw new IllegalArgumentException("Resource with that name doesnt exists: " + resourceName);
    }

    public String getResource(ShopResource shopResource) throws IOException {
        String theme = shopResource.getSiteInfo().getTheme().toString().toLowerCase();
        String lang  = shopResource.getSiteInfo().getLang().toString().toLowerCase();
        String resourceFileName = shopResource.getResource().getFileName();
        String filePath = Paths.get(storagePath, "shops",theme,lang,resourceFileName).toString();
        String jsonContent = FileUtil.readFile(filePath);
        return jsonContent;
    }
}
