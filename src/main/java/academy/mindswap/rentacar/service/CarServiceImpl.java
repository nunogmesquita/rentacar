package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.converter.CarConverter;
import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    CarRepository carRepository;
    CarConverter carConverter = new CarConverter();

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = carConverter.fromCarDtoToEntity(carDto);
        car = carRepository.save(car);
        return carConverter.fromCarEntityToCarDto(car);
    }

    @Override
    public CarDto getCarById(Long carId) {
        Car car = carRepository.getReferenceById(carId);
        return carConverter.fromCarEntityToCarDto(car);
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
