package me.Logicism.OpenRGB4J.openrgb.entities;

public enum ModeDirection {
    LEFT("Left"),
    RIGHT("Right"),
    UP("Up"),
    DOWN("Down"),
    HORIZONTAL("Horizontal"),
    VERTICAL("Vertical");

    private String name;

    ModeDirection(String name) {
        this.name = name;
    }

    public static ModeDirection parseValue(int value) {
        if (value >= ModeDirection.values().length)
            return null;

        return ModeDirection.values()[value];
    }

    public String getName() {
        return name;
    }
}
