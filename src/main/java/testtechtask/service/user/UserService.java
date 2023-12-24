package testtechtask.service.user;

import testtechtask.dto.user.UserDto;
import testtechtask.dto.user.UserRegistrationRequest;
import testtechtask.exception.RegistrationException;

public interface UserService {
    UserDto register(UserRegistrationRequest request) throws RegistrationException;
}
