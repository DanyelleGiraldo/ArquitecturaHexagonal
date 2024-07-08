package infrastucture.in;

import java.util.Scanner;

import application.CreateUserUseCase;
import domain.entity.User;

public class UserController {
    private CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase){
        this.createUserUseCase = createUserUseCase;
    }

    public void start(){
        try (Scanner sc = new Scanner(System.in)){
            System.out.println("Enter user name: ");
            String name = sc.nextLine();

            System.out.println("Enter user email: ");
            String email = sc.nextLine();

            User user = new User();
            user.setName(name);
            user.setEmail(email);
            createUserUseCase.execute(user);
        } catch (Exception e) {
        }
    }

}
