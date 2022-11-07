package com.example.fakecms.infrastructure.dict.controller;

import com.example.fakecms.autoconfigure.exception.ForbiddenException;
import com.example.fakecms.infrastructure.dict.dto.DictDataDto;
import com.example.fakecms.infrastructure.dict.entity.DictData;
import com.example.fakecms.infrastructure.dict.service.DictDataService;
import com.example.fakecms.vo.UnifyResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dictdata")
@RestController
public class DictDataController {

    private DictDataService dictDataService;

    public DictDataController(DictDataService dictDataService) {
        this.dictDataService = dictDataService;
    }

    @PostMapping
    public UnifyResponseVO<String> addDictData(@RequestBody DictDataDto dictDataDto){
        if(!StringUtils.isEmpty(dictDataDto.getDictCode())){
            Boolean exist = dictDataService.checkExistByCodeAndKey(dictDataDto.getDictCode(), dictDataDto.getDictKey());
            if(exist) throw new ForbiddenException(5006);
        }
        DictData dictData = new DictData();
        BeanUtils.copyProperties(dictDataDto, dictData);
        dictDataService.save(dictData);

        UnifyResponseVO<String> stringUnifyResponseVO = new UnifyResponseVO<>();
        stringUnifyResponseVO.setMessage("新增成功");
        return stringUnifyResponseVO;
    }
}
