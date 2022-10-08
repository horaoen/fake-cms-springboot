package com.example.myfirstcms.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myfirstcms.mapper.FileMapper;
import com.example.myfirstcms.pojo.FileDO;
import com.example.myfirstcms.service.FileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, FileDO> implements FileService {


}
