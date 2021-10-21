package com.amigoscode.app.user;

import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> findUserByUsername(String username);
}
