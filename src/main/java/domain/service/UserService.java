package domain.service;

import domain.entity.User;

public interface UserService {
    void createUser(User user);
    User findUserById(Long id);
    void updateUser(Long id, String nombre, String email);
    void delteUser(Long id);
}
