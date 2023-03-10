package academy.mindswap.rentacar.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {

    @NotBlank(message = "The price is")
    private int price;

    @NotBlank(message = "Must have a entry Date")
    private Date entryDate;

    @NotBlank(message = "Must have a finish Date")
    private Date finishDate;



}
