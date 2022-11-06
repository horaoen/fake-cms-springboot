package com.example.fakecms.infrastructure.dict.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.fakecms.autoconfigure.exception.ForbiddenException;
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
    public IPage<Dict> queryPage(@RequestBody DictRequest request) {
        IPage<Dict> queryPage = dictService.queryPage(request);
        return queryPage;
    }

    @PostMapping
    public void add(@RequestBody DictDto dictDto) {
        if(StringUtils.hasText(dictDto.getDictCode())){
            boolean exist = dictService.checkDictExistByDictCode(dictDto.getDictCode());
            if(exist) throw new ForbiddenException(5004);
        }
        Dict dict = new Dict();
        dict.setDeleted("0");
        BeanUtils.copyProperties(dictDto, dict);
        dictService.save(dict);
    }

    @DeleteMapping("{dictId}")
    public String delete(@PathVariable String dictId) {
        dictService.removeById(dictId);
        return "删除成功";
    }

    @PutMapping("{dictId}")
    public String update(@PathVariable String dictId,
    @RequestBody Dict dictDto) {
        if(!StringUtils.isEmpty(dictId)){
            boolean exist = dictService.checkDictExistByDictId(dictId);
            //TODO 最好用NotFoundException，简明知意。
            if(exist) throw new ForbiddenException(5005);
        }
        dictDto.setId(dictId);
        //TODO mybatis plus 标注了逻辑删除注解，有默认值“0”，应该不需要手动添加。
        dictDto.setDeleted("0");
        System.out.println(dictDto);
        dictService.updateById(dictDto);
        return "更新成功";
    }

}
