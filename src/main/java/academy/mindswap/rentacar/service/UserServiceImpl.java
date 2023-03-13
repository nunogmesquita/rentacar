package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.UserCreateDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.exception.IdNotExist;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.repository.UserRepository;
import academy.mindswap.rentacar.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    UserConverter userConverter = new UserConverter();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserCreateDto userCreatedDto) {
        if (!userCreatedDto.getPassword().equals(userCreatedDto.getRetypePassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        User user = userConverter.fromUserCreateDtoToEntity(userCreatedDto);
        user = userRepository.save(user);
        return userConverter.fromUserEntityToUserDto(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> user = userRepository.findUserById(userId);
        if (user.isEmpty()) {
            throw new IdNotExist("User not found");
        }
        return userConverter.fromUserEntityToUserDto(user.get());
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.parallelStream()
                .map(userConverter::fromUserEntityToUserDto)
                .toList();
        return userDtos;
    }

    @Override
    public UserDto updateUser(Long id, UserCreateDto userDto) {
        User user = userRepository.getReferenceById(id);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
        return userConverter.fromUserEntityToUserDto(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}