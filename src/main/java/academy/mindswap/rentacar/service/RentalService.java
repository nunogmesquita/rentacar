package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.RentalDto;

import java.util.List;

public interface RentalService {
    RentalDto createRental (RentalDto rental);

    RentalDto getRentalById(Long rentalId);

    List<RentalDto> getAllRentals();

    RentalDto updateRental(Long id, RentalDto rentalDto);

    void deleteRental(Long rentalId);
}
