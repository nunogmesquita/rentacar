package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.dto.UserDto;
import academy.mindswap.rentacar.model.Car;

import java.util.List;

public interface CarService {
    CarDto createCar(CarDto car);

    CarDto getCarById(Long carId);

    List<CarDto> getAllCars();

    CarDto updateCar(Long id, CarDto car);

    void deleteCar(Long carId);
}
