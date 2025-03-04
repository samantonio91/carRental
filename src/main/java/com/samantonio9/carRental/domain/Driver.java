package com.samantonio9.carRental.domain;

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
@Table(name = "tab_driver")
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "driver_id")
    @JoinColumn(name = "driver_id")
    private Long driverId;


}
