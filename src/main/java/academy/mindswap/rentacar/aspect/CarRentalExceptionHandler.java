package academy.mindswap.rentacar.aspect;

import academy.mindswap.rentacar.exception.IdNotExist;
import academy.mindswap.rentacar.exception.LicensePlateAlreadyExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class CarRentalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CarRentalExceptionHandler.class);

    @ExceptionHandler(value = {IdNotExist.class})
    public ResponseEntity<String> handleIdNotExists(Exception ex) {
        logger.error("Known Exception: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(value = {LicensePlateAlreadyExists.class})
    public ResponseEntity<String> handleLicensePlateAlreadyExists(Exception ex) {
        logger.error("Known Exception: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> handleGenericException(Exception ex) {
        logger.error("Unknown Exception: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
    }
}
