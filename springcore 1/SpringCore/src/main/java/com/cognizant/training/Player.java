package com.cognizant.training;

public class Player
{
    private String playerName;
    private String skill;
    private String country;
    public Player()
    {
        System.out.println("Constructor");
    }
    public Player(String country, String playerName, String skill) {
        this.country = country;
        this.playerName = playerName;
        this.skill = skill;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
