package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
    private String name;
    private Address address;

    public Person(){}

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    //The error you're seeing, NoUniqueBeanDefinitionException is Spring's way of saying: "I see you want a Player bean,
    // but you've defined three of them (player1, player2, player3), and I don't know which one to pick!"
    // can be solved usign Primary or Qualifier(_)
    @Autowired
    //@Qualifier("player2")
    Player favoritePlayer;


    @Override
    public String toString() {
        return "Person{name="  + name + ", address=" + address + ", favoritePlayer="+favoritePlayer.getPlayerName()+ "}";
    }
}
