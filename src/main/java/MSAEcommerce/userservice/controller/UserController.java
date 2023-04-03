package MSAEcommerce.userservice.controller;

import MSAEcommerce.userservice.dto.UserDto;
import MSAEcommerce.userservice.service.UserService;
import MSAEcommerce.userservice.vo.Greeting;
import MSAEcommerce.userservice.vo.RequestUser;
import MSAEcommerce.userservice.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    Greeting greeting;
    private final Environment env;
    private final UserService userService;

    @Autowired
    public UserController(Environment env, UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    @GetMapping("/health_check")
    public String status() {

        return "It is Working in UserService!!";
    }

    @GetMapping("/welcome")
    public String welcome() {

        return env.getProperty("greeting.message");
    }

    @GetMapping("/greeting")
    public String greeting() {

        return greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(user, UserDto.class);
        userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }
}

