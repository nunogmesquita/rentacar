package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

//v@Component
public class UserConverter {
    @Autowired
    ObjectMapper objectMapper;

    public UserDto fromUserEntityToUserDto(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

    public User fromUserDtoToEntity(UserDto userDto){
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())

                .role(userDto.getRole())
                .build();
    }

}