package com.geofence.controller;

import com.geofence.entity.GeofenceEntity;
import com.geofence.model.GeoFenceRequest;
import com.geofence.model.GeoFenceResponse;
import com.geofence.service.GeofenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/geofence")
public class GeofenceController {

                @Autowired
    GeofenceService service;
    @PostMapping("/createGeoFence/v1")
    public ResponseEntity<HttpStatus> createGepFence(@RequestBody GeoFenceRequest request){
    service.saveGeoFence(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/getGeoFence/v1/{id}")
    public ResponseEntity<GeoFenceResponse> getGeoFence(@PathVariable("id") Long id){

        GeoFenceResponse res = service.getGeoFence(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/updateGeoFence/v1")
    public ResponseEntity<GeoFenceResponse> updateGeoFence(@RequestBody GeoFenceRequest entity){
        GeoFenceResponse res= service.updateGeoFence(entity);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @DeleteMapping("/deleteGeoFence/v1/{id}")
    public ResponseEntity<HttpStatus> deleteGeoFence(@PathVariable("id") Long id){

        service.deleteGeoFence(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
