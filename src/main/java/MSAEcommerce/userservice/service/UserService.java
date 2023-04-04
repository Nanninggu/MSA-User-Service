package MSAEcommerce.userservice.service;

import MSAEcommerce.userservice.dto.UserDto;
import MSAEcommerce.userservice.jpa.UserEntity;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
}
