package academy.mindswap.rentacar.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    @NotBlank(message = "Must have first name")
    private String firstName;
    @NotBlank(message = "Must have last name")
    private String lastName;
    @NotBlank(message = "Must have email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email")
    private String email;
    @NotBlank(message = "Invalid password")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Size(max = 12, message = "Password to long")
    private String password;
    @NotBlank(message = "Must have password")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Size(max = 12, message = "Password to long")
    private String retypePassword;
    @NotBlank(message = "Must have email")
    private String role;
}