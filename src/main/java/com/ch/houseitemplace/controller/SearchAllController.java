package com.ch.houseitemplace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/searchAll")
public class SearchAllController {

    // 通过一个key获取所有关键词搜索
    @GetMapping("byKey")
    public String byKey(String key) {
        //搜索物品
/*        searchFromItem(key);
        // 搜索房间
        searchFromRoom(key);
        // 搜索*/
        return "searchAll by key: " + key;
    }

}
