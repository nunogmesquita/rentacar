package academy.mindswap.rentacar.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

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

    @ManyToOne
    private Car car;

    @ManyToOne
    private User user;
}