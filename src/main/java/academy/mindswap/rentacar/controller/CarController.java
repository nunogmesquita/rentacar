package academy.mindswap.rentacar.controller;

import academy.mindswap.rentacar.dto.CarDto;
import academy.mindswap.rentacar.exception.IdNotExist;
import academy.mindswap.rentacar.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> carDtos = carService.getAllCars();
        return new ResponseEntity<>(carDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getById(@PathVariable Long id) throws IdNotExist {
        CarDto car = carService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }
        CarDto savedCar = carService.createCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarDto> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long id, @Valid @RequestBody CarDto car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
        }
        CarDto uptadedCar = carService.updateCar(id, car);
        return new ResponseEntity<>(uptadedCar, HttpStatus.ACCEPTED);
    }

}
