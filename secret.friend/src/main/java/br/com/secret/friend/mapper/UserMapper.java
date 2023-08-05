package br.com.secret.friend.mapper;

import br.com.secret.friend.dto.UserDto;
import br.com.secret.friend.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getDataUpdated(),
                user.getDataCreated());

    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPhone(),
                userDto.getDataUpdated(),
                userDto.getDataCreated());

    }
}
