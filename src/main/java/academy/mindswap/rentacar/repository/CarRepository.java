package academy.mindswap.rentacar.repository;

import academy.mindswap.rentacar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE c.id= :carId")
    Optional<Car> findCarById(Long carId);

    @Query("SELECT c FROM Car c WHERE c.licensePlate= :licensePlate")
    Optional<Car> findCarByLicensePlate(String licensePlate);

}