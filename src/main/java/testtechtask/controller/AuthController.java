package testtechtask.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testtechtask.dto.user.UserDto;
import testtechtask.dto.user.UserLoginRequest;
import testtechtask.dto.user.UserLoginResponse;
import testtechtask.dto.user.UserRegistrationRequest;
import testtechtask.exception.RegistrationException;
import testtechtask.security.AuthenticationService;
import testtechtask.service.user.UserService;

@Tag(name = "Authentication management", description = "Endpoints for managing authentication")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/user")
public class AuthController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    @PermitAll
    @Operation(summary = "Login", description = "Login method to authenticate users")
    public UserLoginResponse login(@RequestBody UserLoginRequest requestDto) {
        return authenticationService.authenticate(requestDto);
    }

    @PostMapping("/register")
    @PermitAll
    @Operation(summary = "Register", description = "Register method to register users")
    public UserDto register(@RequestBody @Valid UserRegistrationRequest request)
            throws RegistrationException {
        return userService.register(request);
    }
}
