package com.ubb935.halfway.model.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ciprian.mosincat on 11/1/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum Ability {

    GUITAR_LESSONS("Guitar lessons"),
    SINGING("Singing"),
    PAINTING("Painting"),
    GARDENING("Gardening"),
    SHOPPING("Shopping"),
    DOG_WALKING("Dog walking"),
    CLEANING("Cleaning"),
    BABYSITTING("Babysitting"),
    COOKING("Cooking"),
    BAKING("Baking"),
    CHESS_LESSONS("Chess lessons"),
    CAR_REPAIRING("Car repairing"),
    BIKE_REPAIRING("Bike repairink");

    String value;

}
