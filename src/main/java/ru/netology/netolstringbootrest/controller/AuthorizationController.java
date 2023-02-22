package ru.netology.netolstringbootrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.netolstringbootrest.authorities.Authorities;
import ru.netology.netolstringbootrest.domain.User;
import ru.netology.netolstringbootrest.exception.InvalidCredentials;
import ru.netology.netolstringbootrest.exception.UnauthorizedUser;
import ru.netology.netolstringbootrest.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }
    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Validated User user) {
        return service.getAuthorities(user);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e){
        System.out.println(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
