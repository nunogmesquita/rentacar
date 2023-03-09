package academy.mindswap.rentacar.controller;

import academy.mindswap.rentacar.model.Car;
import academy.mindswap.rentacar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController (CarService carService){
        this.carService = carService;
    }

    @GetMapping("")
    public Car getCars(){
        return carService.getCar();
    }
}
