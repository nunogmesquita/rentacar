package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Rental;

public class RentalConverter {

    public RentalDto fromRentalEntityToRentalDto(Rental rental) {
        return RentalDto.builder()
                .price(rental.getPrice())
                .entryDate(rental.getEntryDate())
                .finishDate(rental.getFinishDate())
               // falta ainda 2 metodos para relacionar com as foreygn keys
                .build();
    }

    public Rental fromRentalDtoToEntity(RentalDto rentalDto){
        return Rental.builder()
                .price(rentalDto.getPrice())
                .entryDate(rentalDto.getEntryDate())
                .finishDate(rentalDto.getFinishDate())
                // falta ainda 2 metodos para relacionar com as foreygn keys
                .build();
    }
}