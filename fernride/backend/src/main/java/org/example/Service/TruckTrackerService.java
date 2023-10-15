package org.example.Service;

import lombok.RequiredArgsConstructor;
import org.example.Model.Truck;
import org.example.Repository.TruckRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class TruckTrackerService {
    private final TruckRepository truckRepository;

    public void saveTruck(Truck truck) {
        try{
            truckRepository.save(truck);
        } catch (Exception e){
            throw new RuntimeException("Error while inserting/updating truck.");
        }
    }

    public Boolean getTruckHealthInfo(int truckId) {
        try{
            Truck tempTruck = truckRepository.findById(truckId);
            return tempTruck.isHealth();
        } catch (Exception e){
            throw new RuntimeException("Error while getting specific truck.");
        }
    }

    public ArrayList<Truck> getAllTrucks() {
        try{
            ArrayList<Truck> result = new ArrayList<Truck>();
            for(Truck eachTruck : truckRepository.findAll()){
                result.add(eachTruck);
            }
            return result;
        } catch (Exception e){
            throw new RuntimeException("Error while getting all trucks.");
        }
    }
}
