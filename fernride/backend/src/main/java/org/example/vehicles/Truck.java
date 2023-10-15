package org.example.vehicles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Truck {
    private int id;
    private int latitude;
    private int longitude;
    private boolean health;
}
