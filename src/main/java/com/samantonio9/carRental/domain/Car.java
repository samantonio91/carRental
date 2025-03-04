package com.samantonio9.carRental.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tab_car")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("car_id")
    @Column(name = "car_id")
    private Long carId;

    private String type;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Driver driver;

}
