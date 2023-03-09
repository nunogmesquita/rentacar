package academy.mindswap.rentacar.service;

import academy.mindswap.rentacar.model.Car;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{
    @Override
    public Car getCar() {
        return Car.builder()
                .id(1L)
                .brand("Renault")
                .model("Megane")
                .build();
    }
}
