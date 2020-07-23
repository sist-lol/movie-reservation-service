package cml.theaters.moviereservation.domain.multiplex;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Builder  @EqualsAndHashCode(of = "multiplexId")
@AllArgsConstructor @NoArgsConstructor

public class Multiplex {

    @Id @GeneratedValue
    @Column(name = "MULTIPLEX_ID")
    private Long multiplexId;

    @Column(unique = true)
    private String multiplexName;

    private String city;

}
