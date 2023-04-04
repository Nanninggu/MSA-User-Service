package MSAEcommerce.userservice.dto;

import MSAEcommerce.userservice.vo.ResponseOrder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createAtl;

    private String encryptedPwd;

    private List<ResponseOrder> orders;
}
