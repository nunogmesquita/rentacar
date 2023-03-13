package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.converter.CarConverter;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.exception.IdNotExist;
import academy.mindswap.rentacar.exception.LicensePlateAlreadyExists;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    CarRepository carRepository;
    CarConverter carConverter = new CarConverter();

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = carConverter.fromCarDtoToEntity(carDto);
        Optional<Car> car2 = carRepository.findCarByLicensePlate(car.getLicensePlate());
        if (!car2.isEmpty()) {
            throw new LicensePlateAlreadyExists("That license plate already exists.");
        }
        car = carRepository.save(car);
        return carConverter.fromCarEntityToCarDto(car);
    }

    @Override
    public CarDto getCarById(Long carId) {
        Optional<Car> car = carRepository.findCarById(carId);
        if (car.isEmpty()) {
            throw new IdNotExist("Car not found");
        }
        return carConverter.fromCarEntityToCarDto(car.get());
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carRepository.findAll();
        List<CarDto> carDtos = cars.parallelStream()
                .map(carConverter::fromCarEntityToCarDto)
                .toList();
        return carDtos;
    }

    @Override
    public CarDto updateCar(Long id, CarDto carDto) {
        Optional<Car> carUpdate = carRepository.findCarById(id);
        if (carUpdate.isEmpty()) {
            throw new IdNotExist("Car not found");
        }
        Car car = carRepository.getReferenceById(id);
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setLicensePlate(carDto.getLicensePlate());
        carRepository.save(car);
        return carConverter.fromCarEntityToCarDto(car);
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}