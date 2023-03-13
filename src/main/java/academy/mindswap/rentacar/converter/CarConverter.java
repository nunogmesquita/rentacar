package academy.mindswap.rentacar.converter;

import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.model.Car;

public class CarConverter {
    public CarDto fromCarEntityToCarDto(Car car) {
        return CarDto.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .licensePlate(car.getLicensePlate())
                .build();
    }

    public Car fromCarDtoToEntity(CarDto carDto) {
        return Car.builder()
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .licensePlate(carDto.getLicensePlate())
                .build();
    }
}
