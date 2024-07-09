package application;

import domain.service.UserService;

public class DeleteUserUseCase {
    private final UserService userService;

    public DeleteUserUseCase(UserService userService){
        this.userService = userService;
    }
    
    public void execute (Long id){
        userService.delteUser(id);
    }
}
