package com.example.model.controller;

import com.example.model.resources.base.ShopResource;
import com.example.model.resources.base.info.SiteInfo;
import com.example.model.resources.base.resource.Resource;
import com.example.model.service.ResourceService;
import com.example.model.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/backend/resources")
public class ResourcesController {

    @Autowired
    ResourceService resourceService;

    @Autowired
    SiteService siteService;


    @GetMapping("/resource")
    public String findResourceByNameAndShopCode(@RequestParam("resourceName") String resourceName, @RequestParam("shopCode") String shopCode) throws IOException {
        Resource resource = resourceService.findByName(resourceName);
        SiteInfo siteInfo = siteService.findByShopCode(shopCode);
        ShopResource shopResource = new ShopResource(resource,siteInfo);
        return resourceService.getResource(shopResource);
    }
}
