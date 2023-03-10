package academy.mindswap.rentacar.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {

    @NotNull(message = "The price is")
    private int price;

    @NotNull(message = "Must have a entry Date")
    private Date entryDate;

    @NotNull(message = "Must have a finish Date")
    private Date finishDate;

    @NotNull(message = "Must choose a car")
    private Long carId;

    @NotNull(message = "Must choose a client")
    private Long userId;
}