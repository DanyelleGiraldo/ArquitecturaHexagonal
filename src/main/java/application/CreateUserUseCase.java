package application;

import domain.entity.User;
import domain.service.UserService;

public class CreateUserUseCase {
    private final UserService userService;

    public CreateUserUseCase(UserService userService){
        this.userService = userService;
    }
    
    public void execute (User user){
        userService.createUser(user);
    }
}
