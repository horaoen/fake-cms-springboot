package com.example.myfirstcms.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@TableName("lin_dict")
public class DictDO extends BaseAllHave implements Serializable {


    private static final long serialVersionUID = 8551746589648201998L;

    private String dict_name;

    private String dict_type;

    private String dict_remark;
}
