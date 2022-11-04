package com.example.fakecms.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class DispatchPermissionDTO {

    @Positive(message = "{group.id.positive}")
    @NotNull(message = "{group.id.not-null}")
    private Integer groupId;

    private Integer permissionId;
}
