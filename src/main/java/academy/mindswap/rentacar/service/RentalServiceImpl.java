package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.converter.RentalConverter;
import academy.mindswap.rentacar.dto.RentalDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.model.Rental;
import academy.mindswap.rentacar.model.User;
import academy.mindswap.rentacar.repository.CarRepository;
import academy.mindswap.rentacar.repository.RentalRepository;
import academy.mindswap.rentacar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

    RentalRepository rentalRepository;

    UserRepository userRepository;

    CarRepository carRepository;

    RentalConverter rentalConverter = new RentalConverter();

    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository, UserRepository userRepository, CarRepository carRepository) {
        this.rentalRepository = rentalRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @Override
    public RentalDto createRental(RentalDto rentalDto) {
        User user = userRepository.getReferenceById(rentalDto.getUserId());
        Car car = carRepository.getReferenceById(rentalDto.getCarId());
        Rental rental = rentalConverter.fromRentalDtoToEntity(rentalDto, car, user);
        rental = rentalRepository.save(rental);
        return rentalConverter.fromRentalEntityToRentalDto(rental);
    }

    @Override
    public RentalDto getRentalById(Long rentalId) {
        Rental rental = rentalRepository.getReferenceById(rentalId);
        return rentalConverter.fromRentalEntityToRentalDto(rental);
    }

    @Override
    public List<RentalDto> getAllRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        List<RentalDto> rentalDto = rentals.parallelStream()
                .map(rentalConverter::fromRentalEntityToRentalDto)
                .toList();
        return rentalDto;
    }

    @Override
    public RentalDto updateRental(Long id, RentalDto rentalDto) {
        Rental rental = rentalRepository.getReferenceById(id);
        rental.setPrice(rentalDto.getPrice());
        rental.setEntryDate(rentalDto.getEntryDate());
        rental.setFinishDate(rentalDto.getFinishDate());
        //rental.setRole(userDto.getID());  FALTA METER FOREYNG KEY
        //rental.setEmail(userDto.getEmail()); FALTA METER FOREYNG KEY
        rentalRepository.save(rental);
        return rentalConverter.fromRentalEntityToRentalDto(rental);
    }

    @Override
    public void deleteRental(Long rentalId) {
        rentalRepository.deleteById(rentalId);
    }
    // esta parte onde temos rentalID, não será colocar o userID por causa das ligações às tabelas?
}