package testtechtask.mapper.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import testtechtask.config.MapperConfig;
import testtechtask.dto.user.UserDto;
import testtechtask.dto.user.UserRegistrationRequest;
import testtechtask.model.User;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    User toModel(UserRegistrationRequest request);
}
