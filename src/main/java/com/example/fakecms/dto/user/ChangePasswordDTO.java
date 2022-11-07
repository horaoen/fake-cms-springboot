package com.example.fakecms.dto.user;

import com.example.fakecms.autoconfigure.validator.EqualField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@EqualField(srcField = "newPassword", dstField = "confirmPassword", message = "{password.equal-field}")
public class ChangePasswordDTO {

    @NotBlank(message = "{password.old.not-blank}")
    @Schema(name = "旧密码")
    private String oldPassword;

    @NotBlank(message = "{password.new.not-blank}")
    @Schema(name = "新密码")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "{password.new.pattern}")
    private String newPassword;

    @Schema(name = "确认密码")
    @NotBlank(message = "{password.confirm.not-blank}")
    private String confirmPassword;

}
