package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.UserCreateDto;
import academy.mindswap.rentacar.dto.UserDto;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {

    UserDto createUser(@Valid UserCreateDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long id, UserCreateDto user);

    void deleteUser(Long userId);
}