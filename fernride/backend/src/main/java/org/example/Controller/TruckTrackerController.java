package org.example.Controller;

import org.example.Service.TruckTrackerService;
import org.example.Model.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin()
@Controller
public class TruckTrackerController {

    @Autowired
    private TruckTrackerService truckTrackerService;

    @PutMapping(path = "/saveTruckData")
    public ResponseEntity<?> updateResource(@RequestBody Truck truck) {
        try{
            truckTrackerService.saveTruck(truck);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Truck data can not be saved.");
        }
        // return "Truck data is saved.";
    }


    @GetMapping(path = "/getTruckData")
    public ResponseEntity<?> getTruckData(@RequestParam(name = "truckid") int truckId) {
        try{
            return new ResponseEntity<Object>(
                    truckTrackerService.getTruckHealthInfo(truckId),
                    HttpStatus.OK);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error during getting truck's health status.");
        }
    }

    @GetMapping(path = "/getAllTrucks")
    public ResponseEntity<?> getAllTrucks() {
        try{
            return new ResponseEntity<Object>(
                    truckTrackerService.getAllTrucks(),
                    HttpStatus.OK);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error during getting all trucks' health status.");
        }
    }
}
