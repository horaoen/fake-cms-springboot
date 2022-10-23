package com.example.myfirstcms.dto.admin;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class NewGroupDTO {
    private String name;

    private String info;

    private List<Integer> permissionIds;
}
