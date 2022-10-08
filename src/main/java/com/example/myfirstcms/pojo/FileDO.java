package com.example.myfirstcms.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@TableName("lin_file")
public class FileDO extends BaseAllHave implements Serializable {


    private static final long serialVersionUID = -6965603425668879007L;

    private String path;

    /*本地 or 远端*/
    private String type;

    private String name;

    private String extension;

    private Integer size;

    /**
     * md5值，防止上传重复文件
     */
    private String md5;
}
