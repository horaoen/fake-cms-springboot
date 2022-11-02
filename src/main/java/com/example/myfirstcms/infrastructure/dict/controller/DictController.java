package com.example.myfirstcms.infrastructure.dict.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myfirstcms.autoconfigure.exception.ForbiddenException;
import com.example.myfirstcms.infrastructure.dict.dto.DictDto;
import com.example.myfirstcms.infrastructure.dict.dto.DictRequest;
import com.example.myfirstcms.infrastructure.dict.entity.Dict;
import com.example.myfirstcms.infrastructure.dict.service.DictService;
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
    public IPage<Dict> queryPage(@RequestBody DictRequest request) {
        IPage<Dict> queryPage = dictService.queryPage(request);
        return queryPage;
    }

    @PostMapping
    public void add(@RequestBody DictDto dictDto) {
        //TODO 检查dictCode是否存在，然后抛出异常。
        if(StringUtils.hasText(dictDto.getDictCode())){
            boolean exist = dictService.checkDictExistByDictCode(dictDto.getDictCode());
            if(exist) throw new ForbiddenException(5004);
        }
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictDto, dict);
        dictService.save(dict);
    }

    @DeleteMapping("{dictId}")
    public String delete(@PathVariable String dictId) {
        dictService.removeById(dictId);
        return "删除成功";
    }

}
