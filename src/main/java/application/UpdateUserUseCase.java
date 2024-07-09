package application;
import domain.service.UserService;

public class UpdateUserUseCase {
    private final UserService userService;

    public UpdateUserUseCase(UserService userService) {
        this.userService = userService;
    }

    public void execute(Long id, String nombre, String email){
        userService.updateUser(id, nombre, email);
    }}
