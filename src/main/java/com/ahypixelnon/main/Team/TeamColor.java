package com.ahypixelnon.main.Team;

import org.bukkit.Color;

public class TeamColor {
    String prefixColor;
    String teamName;
    Color color;
    int colorID;

    public TeamColor(String prefixColor, String teamName, Color color, int colorID) {
        this.prefixColor = prefixColor;
        this.teamName = teamName;
        this.color = color;
        this.colorID = colorID;
    }

    public Color getColor() {
        return this.color;
    }

    public String getChatColor() {
        return this.prefixColor;
    }

    public byte getByteColor() {
        return (byte)this.colorID;
    }

    public int getIntColor() {
        return this.colorID;
    }

    public String getTeamName() {
        return this.teamName;
    }
}
