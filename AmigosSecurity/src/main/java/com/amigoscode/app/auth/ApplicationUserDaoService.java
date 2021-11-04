package com.amigoscode.app.auth;

import com.amigoscode.app.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.amigoscode.app.security.ApplicationUserRole.valueOf;

@Repository
public class ApplicationUserDaoService implements ApplicationUserDao{

    @Autowired
    private UserService userService;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return userService.findUserByUsername(username)
                .map(user -> {
                    return new ApplicationUser(
                            user.getUsername(),
                            user.getPassword(),
                            valueOf(user.getRole().toUpperCase()).getGrantedAuthorities(),
                            true,
                            true,
                            true,
                            true
                    );
                });
    }
}
