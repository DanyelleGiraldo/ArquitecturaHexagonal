package application;

import domain.entity.User;
import domain.service.UserService;

public class FindUserUseCase {
    private final UserService userService;

    public FindUserUseCase(UserService userService) {
        this.userService = userService;
    }

    public User execute(Long id){
        User user = userService.findUserById(id);
        if (user != null) {
            return user; 
        } else {
            return null;
        }
    }
}
