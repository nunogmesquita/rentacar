package academy.mindswap.rentacar.repository;

import academy.mindswap.rentacar.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    @Query("SELECT c FROM Rental c WHERE c.id= :rentalId")
    Optional<Rental> findRentalById(@Param("rentalId") Long rentalId);
}