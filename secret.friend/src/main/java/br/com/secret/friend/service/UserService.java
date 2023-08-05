package br.com.secret.friend.service;

import br.com.secret.friend.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserDto> saveUser(UserDto userDto);

    Mono<UserDto> getUser(String userId);

    Flux<UserDto> getAllUsers();

    Mono<UserDto> updateUser(UserDto userDto, String userId);

    Mono<Void>deleteEmployee(String userId);
}
