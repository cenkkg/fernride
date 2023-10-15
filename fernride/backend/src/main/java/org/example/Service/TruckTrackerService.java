package org.example.Service;

import org.example.vehicles.Truck;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TruckTrackerService {
    HashMap<Integer, Truck> trucks = new HashMap<Integer, Truck>();

    public void saveTruck(Truck truck) {
        try{
            trucks.put(truck.getId(), truck);
        } catch (Exception e){
            throw new RuntimeException("Error while inserting/updating truck.");
        }
    }

    public Boolean getTruckHealthInfo(int truckId) {
        try{
            return trucks.get(truckId).isHealth();
        } catch (Exception e){
            throw new RuntimeException("Error while inserting/updating truck.");
        }
    }
}
