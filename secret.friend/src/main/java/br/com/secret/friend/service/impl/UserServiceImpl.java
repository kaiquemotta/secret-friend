package br.com.secret.friend.service.impl;

import br.com.secret.friend.dto.UserDto;
import br.com.secret.friend.entity.User;
import br.com.secret.friend.mapper.UserMapper;
import br.com.secret.friend.repository.UserRepository;
import br.com.secret.friend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public Mono<UserDto> saveUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        Mono<User> savedUser = userRepository.save(user);
        return savedUser.map(UserMapper::mapToUserDto);
    }

    @Override
    public Mono<UserDto> getUser(String userId) {
        Mono<User> userMono = userRepository.findById(userId);
        return userMono.map(UserMapper::mapToUserDto);
    }

    @Override
    public Flux<UserDto> getAllUsers() {
        Flux<User> userFlux = userRepository.findAll();
        return userFlux.map(UserMapper::mapToUserDto);
    }

    @Override
    public Mono<UserDto> updateUser(UserDto userDto, String userId) {

        Mono<User> userMono = userRepository.findById(userId);

        return userMono.flatMap((existingUser) -> {
            existingUser.setName(userDto.getName());
            existingUser.setPhone(userDto.getPhone());
            existingUser.setEmail(userDto.getEmail());
            existingUser.setDataUpdated(LocalDateTime.now().toString());
            return userRepository.save(existingUser);
        }).map(UserMapper::mapToUserDto);

    }

    @Override
    public Mono<Void> deleteEmployee(String userId) {
        return userRepository.deleteById(userId);
    }
}
