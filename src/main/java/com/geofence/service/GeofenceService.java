package com.geofence.service;

import com.geofence.exception.DataInsertionException;
import com.geofence.exception.NoDataFoundException;
import com.geofence.entity.GeofenceEntity;
import com.geofence.model.GeoFenceRequest;
import com.geofence.model.GeoFenceResponse;
import com.geofence.repository.GeofenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
@Service
public class GeofenceService {
    @Autowired
    GeofenceRepo repo;

    public void saveGeoFence(GeoFenceRequest request){
        GeofenceEntity entity = new GeofenceEntity();
        entity.setLatitude(request.getLatitude());
        entity.setLongitude(request.getLongitude());
        entity.setRadius(request.getRadius());
        try {
            repo.save(entity);
        }catch (DataAccessException e){
            throw new DataInsertionException(e.getLocalizedMessage());
        }


    }

    public GeoFenceResponse getGeoFence(Long id){
        GeofenceEntity entity =  repo.findById(id).orElseThrow(() -> new NoDataFoundException("No such data exists"));
        GeoFenceResponse res = new GeoFenceResponse();
        res.setLongitude(entity.getLongitude());
        res.setRadius(entity.getRadius());
        res.setLatitude(entity.getLatitude());
        res.setId(entity.getId());
        return res;
    }

    public GeoFenceResponse updateGeoFence(GeoFenceRequest req){
        GeofenceEntity dbEntity = repo.findById(req.getId()).orElseThrow(() -> new NoDataFoundException("No such data exists"));
        dbEntity.setLatitude(req.getLatitude());
        dbEntity.setLongitude(req.getLongitude());
        dbEntity.setRadius(req.getRadius());
        dbEntity =  repo.save(dbEntity);
        GeoFenceResponse res = new GeoFenceResponse();
        res.setLatitude(dbEntity.getLatitude());
        res.setLongitude(dbEntity.getLongitude());
        res.setRadius(dbEntity.getRadius());
        res.setId(dbEntity.getId());
       return res;
    }

    public void deleteGeoFence(long id){
        try {
            repo.deleteById(id);
        }catch (Exception e){
            throw new NoDataFoundException("No such data found while deleting!!!!!");
        }
    }
}
