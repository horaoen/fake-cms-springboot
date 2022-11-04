package com.example.fakecms.dto.user;

import com.example.fakecms.autoconfigure.validator.EqualField;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@EqualField(srcField = "newPassword", dstField = "confirmPassword", message = "{password.equal-field}")
public class ChangePasswordDTO {

    @NotBlank(message = "{password.old.not-blank}")
    private String oldPassword;

    @NotBlank(message = "{password.new.not-blank}")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "{password.new.pattern}")
    private String newPassword;

    @NotBlank(message = "{password.confirm.not-blank}")
    private String confirmPassword;

}
