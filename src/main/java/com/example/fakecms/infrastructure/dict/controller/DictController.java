package com.example.fakecms.infrastructure.dict.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.fakecms.autoconfigure.exception.ForbiddenException;
import com.example.fakecms.autoconfigure.exception.NotFoundException;
import com.example.fakecms.infrastructure.dict.dto.DictDto;
import com.example.fakecms.infrastructure.dict.dto.DictRequest;
import com.example.fakecms.infrastructure.dict.entity.Dict;
import com.example.fakecms.infrastructure.dict.service.DictService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/dict")
@Tag(name = "字典管理")
public class DictController {

    private final DictService dictService;

    public DictController(DictService dictService) {
        this.dictService = dictService;
    }

    @PostMapping("/queryPage")
    @Operation(summary = "字典管理分页查询")
    public IPage<Dict> queryDictPage(@RequestBody DictRequest request) {
        IPage<Dict> queryPage = dictService.queryPage(request);
        return queryPage;
    }

    @PostMapping
    @Operation(summary = "字典管理新增")
    public void addDictCode(@RequestBody DictDto dictDto) {
        if(StringUtils.hasText(dictDto.getDictCode())){
            boolean exist = dictService.checkDictExistByDictCode(dictDto.getDictCode());
            if(exist) throw new ForbiddenException(5004);
        }
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictDto, dict);
        dictService.save(dict);
    }

    @DeleteMapping("{dictId}")
    @Operation(summary = "字典管理根据id删除")
    public String deleteByDictId(@PathVariable String dictId) {
        dictService.removeById(dictId);
        return "删除成功";
    }

    @PutMapping("{dictId}")
    @Operation(summary = "字典管理根据id进行跟新")
    public String updateByDictId(@PathVariable String dictId,
    @RequestBody Dict dictDto) {
        if(!StringUtils.isEmpty(dictId)){
            boolean exist = dictService.checkDictExistByDictId(dictId);
            if(!exist) throw new NotFoundException(5005);
        }
        dictDto.setId(dictId);
        dictService.updateById(dictDto);
        return "更新成功";
    }

}
