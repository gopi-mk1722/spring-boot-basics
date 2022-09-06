package com.geofence.repository;

import com.geofence.entity.GeofenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeofenceRepo extends JpaRepository<GeofenceEntity, Long> {
}