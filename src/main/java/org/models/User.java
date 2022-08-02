package org.models;

public class User {
    int id;
    String name;
    int maxTotalPoints;

    public User(int id, String name, int maxTotalPoints) {
        this.id = id;
        this.name = name;
        this.maxTotalPoints = maxTotalPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxTotalPoints() {
        return maxTotalPoints;
    }

    public void setMaxTotalPoints(int maxTotalPoints) {
        this.maxTotalPoints = maxTotalPoints;
    }
}
