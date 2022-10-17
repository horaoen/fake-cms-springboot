package com.example.myfirstcms.controller;


import com.example.myfirstcms.autoconfigure.exception.ForbiddenException;
import com.example.myfirstcms.core.utils.LocalUser;
import com.example.myfirstcms.mapper.DictMapper;
import com.example.myfirstcms.pojo.DictDO;
import com.example.myfirstcms.pojo.UserDO;
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
    public UserDO test()  {
        return LocalUser.getLocalUser();
    }
}
