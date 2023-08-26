package br.com.secret.friend.mapper;

import br.com.secret.friend.dto.UserDto;
import br.com.secret.friend.entity.User;

import java.time.LocalDateTime;

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

    public static User mapToUser(UserDto userDto,boolean creat) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPhone(),
                creat ? LocalDateTime.now().toString():userDto.getDataUpdated(),
                creat ? LocalDateTime.now().toString():userDto.getDataCreated());

    }
}
