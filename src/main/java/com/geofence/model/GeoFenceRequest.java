package com.geofence.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class GeoFenceRequest {
    private Long id;

    private BigDecimal longitude;

    private BigDecimal latitude;
    private BigDecimal radius;
}

