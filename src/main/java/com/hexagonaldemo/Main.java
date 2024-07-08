package com.hexagonaldemo;

import application.CreateUserUseCase;
import domain.service.UserService;
import infrastucture.in.UserController;
import infrastucture.out.UserRepository;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserRepository();
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
        UserController consoleAdapter = new UserController(createUserUseCase);

        consoleAdapter.start();
    }
}