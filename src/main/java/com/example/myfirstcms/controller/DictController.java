package com.example.myfirstcms.controller;


import com.example.myfirstcms.autoconfigure.exception.ForbiddenException;
import com.example.myfirstcms.mapper.DictMapper;
import com.example.myfirstcms.pojo.DictDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/dict")
@RestController
public class DictController {

    @Autowired
    private DictMapper dictMapper;

    @GetMapping("/test")
    public String test()  {
        return "12345";
    }
}
