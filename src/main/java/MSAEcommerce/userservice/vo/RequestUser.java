package MSAEcommerce.userservice.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestUser {

    @NotNull (message = "이메일은 빈 값을 넣을수 없습니다. 반드시 값을 입력해 주세요.")
    @Size (min = 2, message = "이메일의 최소 길이는 2글자 이상 입니다.")
    @Email
    private String email;

    @NotNull (message = "이름은 빈 값을 넣을수 없습니다. 반드시 값을 입력해 주세요.")
    @Size (min = 1, message = "이름의 최소 길이는 1글자 이상 입니다.")
    private String name;

    @NotNull (message = "패스워드는 빈 값을 넣을수 없습니다. 반드시 값을 입력해 주세요.")
    @Size (min = 8, message = "패스워드의 최소 길이는 8글자 이상 입니다.")
    private String pwd;
    
}
