package com.example.code;

public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * This is a class that defines a City.
     */
    public City(String name, String province) {
        this.city = name;
        this.province = province;
    }

    /**
     * Returns city name
     * @return
     * the name of the city
     */
    public String getCityName() {
        return city;
    }

    /**
     * Sets the name of the city
     * @param name
     * String to be set to the new city name
     */
    public void setName(String name) {
        this.city = name;
    }

    /**
     * Returns province name
     * @return
     * the name of the province
     */
    public String getProvinceName() {
        return province;
    }

    /**
     * Sets the name of the province
     * @param province
     * String to be set to the new province name
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Override method for sorting cities
     * @param city
     * The city that is being compared
     * @return
     * the output of comateTo of a city
     */
    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
}

