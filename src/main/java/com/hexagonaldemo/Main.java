package com.hexagonaldemo;

import application.CreateUserUseCase;
import application.FindUserUseCase;
import application.UpdateUserUseCase;
import domain.service.UserService;
import infrastucture.in.UserController;
import infrastucture.out.UserRepository;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserRepository();
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
        FindUserUseCase findUserUseCase = new FindUserUseCase(userService); 
        UpdateUserUseCase updateUserUseCase = new UpdateUserUseCase(userService);
        UserController consoleAdapter = new UserController(createUserUseCase, findUserUseCase, updateUserUseCase); 

        consoleAdapter.start();
    }
}
