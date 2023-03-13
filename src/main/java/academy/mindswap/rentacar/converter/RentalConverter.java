package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.Rental;
import academy.mindswap.rentacar.model.User;

public class RentalConverter {

    public RentalDto fromRentalEntityToRentalDto(Rental rental) {
        return RentalDto.builder()
                .price(rental.getPrice())
                .entryDate(rental.getEntryDate())
                .finishDate(rental.getFinishDate())
                .carId(rental.getCar().getId())
                .userId(rental.getUser().getId())
                .build();
    }

    public Rental fromRentalDtoToEntity(RentalDto rentalDto, Car car, User user) {
        return Rental.builder()
                .price(rentalDto.getPrice())
                .entryDate(rentalDto.getEntryDate())
                .finishDate(rentalDto.getFinishDate())
                .car(car)
                .user(user)
                .build();
    }
}