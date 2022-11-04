package com.example.fakecms.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@TableName("lin_dict_data")
public class DictDataDO extends BaseAllHave implements Serializable {
    private static final long serialVersionUID = -4043865590343278970L;

    private String dict_lable;

    private String dict_type;

    private String remark;
}
