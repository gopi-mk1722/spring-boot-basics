package com.geofence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Getter
@Setter
public class GeofenceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private BigDecimal longitude;
    @Column
    private BigDecimal latitude;
    @Column
    private BigDecimal radius;
}
