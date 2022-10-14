package com.example.myfirstcms.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@TableName("lin_dict")
public class DictDO extends BaseAllHave implements Serializable {


    private static final long serialVersionUID = 8551746589648201998L;

    private String dict_name;

    private String dict_type;

    private String dict_remark;
}
