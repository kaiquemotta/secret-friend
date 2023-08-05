package br.com.secret.friend.controller;


import br.com.secret.friend.dto.UserDto;
import br.com.secret.friend.entity.User;
import br.com.secret.friend.mapper.UserMapper;
import br.com.secret.friend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<UserDto> saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @GetMapping(value = "{id}")
    public Mono<UserDto> getUser(@PathVariable("id") String userId) {
        return userService.getUser(userId);
    }

    @GetMapping
    public Flux<UserDto> getAllEmployees() {
        return userService.getAllUsers();
    }

    @PutMapping(value = "{id}")
    public Mono<UserDto> updateEmployee(@RequestBody UserDto employeeDto, @PathVariable("id") String employeeId) {
        return userService.updateUser(employeeDto, employeeId);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployee(@PathVariable("id") String employeeId) {
        return userService.deleteEmployee(employeeId);
    }


}
