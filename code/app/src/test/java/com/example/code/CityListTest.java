package com.example.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City addedCity = new City("Yellowknife", "Northwest Territories");
        cityList.add(addedCity);

        City cityNotAdded = new City("blah", "blah blah");

        assertEquals(true, cityList.hasCity(addedCity));
        assertEquals(false, cityList.hasCity(cityNotAdded));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City deletedCity = new City("Yellowknife", "Northwest Territories");
        cityList.add(deletedCity);

        City cityNotAdded = new City("blah", "blah blah");

        cityList.delete(deletedCity);

        assertEquals(false, cityList.hasCity(deletedCity));
        assertThrows(IllegalArgumentException.class,() -> {cityList.delete(cityNotAdded);});
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        City cityOne = new City("Yellowknife", "Northwest Territories");
        cityList.add(cityOne);
        assertEquals(2, cityList.countCities());
    }

}
