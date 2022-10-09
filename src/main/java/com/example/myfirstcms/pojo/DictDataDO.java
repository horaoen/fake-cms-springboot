package com.example.myfirstcms.pojo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DictDataDO extends BaseAllHave implements Serializable {
    private static final long serialVersionUID = -4043865590343278970L;

    private String dict_lable;

    private String dict_type;

    private String remark;
}
