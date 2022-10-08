package com.example.myfirstcms.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myfirstcms.mapper.LogMapper;
import com.example.myfirstcms.pojo.LogDO;
import com.example.myfirstcms.service.LogService;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, LogDO> implements LogService {


}
