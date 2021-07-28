package com.ahypixelnon.main.Team;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import com.ahypixelnon.main.GameWork.PointsEntry;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamBridge {
    public int color = -1;
    public Location spawn;
    public Location respawn;
    public Location pit;
    public List<String> gamePlayers = new ArrayList();
    public PointsEntry entryPit = new PointsEntry();
    int scorePoints = 0;
    public Team teamDisplay;
    public TeamColor teamColor;

    public void ClearUserDataFromGame() {
        this.scorePoints = 0;
        this.teamDisplay = null;
        this.gamePlayers.clear();
    }

    public TeamBridge(int color, Location spawn, Location respawn, Location pit) {
        this.color = color;
        this.respawn = respawn;
        this.spawn = spawn;
        this.pit = pit;
    }

    public void SaveTeamData(FileConfiguration config, int teamNumber) {
        String teamConfPref = "game.team_" + teamNumber;
        config.set(teamConfPref + ".color", this.color);
    }

    public int addGamePlayer(String playerName) {
        if (!this.gamePlayers.contains(playerName)) {
            this.gamePlayers.add(playerName);
            return this.gamePlayers.size();
        } else {
            return -1;
        }
    }

    public List<String> getTeamPlayers() {
        return this.gamePlayers;
    }

    public Location getTeamSpawn() {
        return this.spawn.clone();
    }

    public Location getTeamRespawn() {
        return this.respawn.clone();
    }

    public Location getTeamPit() {
        return this.pit.clone();
    }

    public int getTeamColor() {
        return this.color;
    }

    public int getScorePoints() {
        return this.scorePoints;
    }
}
