package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.exception.IdNotExist;

import java.util.List;

public interface CarService {
    CarDto createCar(CarDto car);

    CarDto getCarById(Long carId) throws IdNotExist;

    List<CarDto> getAllCars();

    CarDto updateCar(Long id, CarDto car);

    void deleteCar(Long carId);
}