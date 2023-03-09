package academy.mindswap.rentacar.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rentals")
public class Rental {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private Date entryDate;

    @Column(nullable = false)
    private Date finishDate;

    private Car car;
    private User user;

    // verificar se será com este método car e user.
    // pretendemos que esta classe rental tenha a informação dos carros alugados e que users alugaram os carros.
}
