package academy.mindswap.rentacar.exception;

public class LicensePlateAlreadyExists extends RuntimeException {
    public LicensePlateAlreadyExists(String licensePlateMessage) {
        super(licensePlateMessage);
    }
}
