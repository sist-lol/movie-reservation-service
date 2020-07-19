package cml.theaters.moviereservation.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Multiplex {

    @Id @GeneratedValue
    @Column(name = "MULTIPLEX_ID")
    private Long multiplexId;

    @Column(unique = true)
    private String multiplexName;

    private String city;

}
