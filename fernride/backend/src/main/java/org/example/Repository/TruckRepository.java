package org.example.Repository;

import java.util.Optional;
import java.util.UUID;

import org.example.Model.Truck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface TruckRepository extends CrudRepository<Truck, Integer> {
    Truck findById(int truckId);
}
