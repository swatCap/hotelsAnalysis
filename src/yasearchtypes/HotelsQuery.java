/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yasearchtypes;

/**
 *
 * @author margarita
 */
class HotelsQuery {
    
    private String name;
    private String city;

    public HotelsQuery(String name, String city) {
        this.name = name;
        this.city = city;
    }
    
    public String generateQuery() {
        return "отель " + name + " " + city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
}
