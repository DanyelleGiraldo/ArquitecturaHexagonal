package infrastucture.in;

import java.util.Scanner;

import application.CreateUserUseCase;
import application.DeleteUserUseCase;
import application.FindUserUseCase;
import application.UpdateUserUseCase;
import domain.entity.User;

public class UserController {
    private CreateUserUseCase createUserUseCase;
    private FindUserUseCase findUserUseCase;
    private UpdateUserUseCase updateUserUseCase;
    private DeleteUserUseCase deleteUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, FindUserUseCase findUserUseCase, UpdateUserUseCase updateUserUseCase, DeleteUserUseCase deleteUserUseCase){
        this.createUserUseCase = createUserUseCase;
        this.findUserUseCase = findUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    public void start(){
        Scanner scz = new Scanner(System.in);

        System.out.println("Select your choice \n 1: Create user \n 2: Search user \n 3: Update user \n 4: Delete user");
        int choice = scz.nextInt();
        switch (choice) {
            case 1:
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
            break;
            case 2:
                try (Scanner sz = new Scanner(System.in)) {
                    System.out.println("Enter user id: ");
                    Long userId = sz.nextLong();
                    sz.nextLine();

                    User foundUser = findUserUseCase.execute(userId);

                    if (foundUser != null) {
                        System.out.println("User found:");
                        System.out.println("ID: " + foundUser.getId());
                        System.out.println("Name: " + foundUser.getName());
                        System.out.println("Email: " + foundUser.getEmail());
                    } else {
                        System.out.println("User not found with id: " + userId);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try(Scanner sl = new Scanner(System.in)){
                    System.out.println("Enter user id: ");
                    Long userID = sl.nextLong();
                    sl.nextLine();

                    User foundUser = findUserUseCase.execute(userID);
                    if(foundUser != null){
                        System.out.println("Enter user name: ");
                        String name = sl.nextLine();
                        System.out.println("Enter user email: ");
                        String email = sl.nextLine();
                        updateUserUseCase.execute(userID, name, email);
                    } else {
                        System.out.println("User not found with id: "+ userID);
                    }
                }
                break;
            case 4:
                try(Scanner sl = new Scanner(System.in)){
                    System.out.println("Enter user id: ");
                    Long userID = sl.nextLong();
                    sl.nextLine();

                    User foundUser = findUserUseCase.execute(userID);
                    if(foundUser != null){
                        deleteUserUseCase.execute(userID);
                    } else {
                        System.out.println("User not found with id: "+ userID);
                    }
                }
                break;
            default:
                break;
        }
        scz.close();
        
    }

}
