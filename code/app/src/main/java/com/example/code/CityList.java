package com.example.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kotlin.contracts.Returns;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Returns whether a city is in the list
     * @param city
     * This is a city that's checked to see if it's in the list
     * @return
     * Returns true if the list has city and false otherwise
     */
    public Boolean hasCity(City city){
        return cities.contains(city);
    }

    /**
     * Checks if a city is in the list, if it is the city gets deleted; if it is not an exception is thrown.
     * @param city
     * This is the city that is deleted
     */
    public void delete(City city){
        if(hasCity(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns the number if cities in the list
     * @return
     * the number of cities in the list as an integer.
     */
    public int countCities() {
        return cities.size();
    }
}
