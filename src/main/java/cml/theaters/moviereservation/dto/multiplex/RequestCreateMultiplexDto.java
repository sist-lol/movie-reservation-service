package cml.theaters.moviereservation.dto.multiplex;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class RequestCreateMultiplexDto {
    @Id
    @GeneratedValue
    @Column(name = "MULTIPLEX_ID")
    private Long multiplexId;

    @Column(unique = true)
    private String multiplexName;

    private String city;

}
