package com.ahypixelnon.main.Team;


import org.bukkit.inventory.ItemStack;

public class TeamPlayer {
    public int points;
    public int teamNumber = -1;
    String playerName;
    String uuid;
    public ItemStack[] inventory;
    public ItemStack helmet;
    public ItemStack chestplate;
    public ItemStack leggings;
    public ItemStack boots;
    public String LastDamager;
    public Long lastDamaged;
    public int kills = 0;

    public TeamPlayer(String playerName) {
        this.playerName = playerName; }

    int getTeam() {
        return this.teamNumber; }

    void setTeam(int teamNumber) {
        this.teamNumber = teamNumber; }

    String getName() {
        return this.playerName;
    }
}
