package com.ahypixelnon.main.GameWork;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PointsEntry {
    List<Point> points = new ArrayList();

    public PointsEntry() {
    }

    boolean isInPoints(Location l) {
        Iterator var3 = this.points.iterator();

        Point p;
        do {
            if (!var3.hasNext()) {
                return false;
            }

            p = (Point)var3.next();
        } while(l.getBlockX() != p.x || l.getBlockY() != p.y || l.getBlockZ() != p.z);

        return true;
    }
}
