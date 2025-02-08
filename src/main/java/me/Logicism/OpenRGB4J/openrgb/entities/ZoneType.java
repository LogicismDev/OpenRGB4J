package me.Logicism.OpenRGB4J.openrgb.entities;

public enum ZoneType {
    SINGLE("Single"),
    LINEAR("Linear"),
    MATRIX("Matrix");

    private String name;

    ZoneType(String name) {
        this.name = name;
    }

    public static ZoneType parseValue(int value) {
        if (value >= ZoneType.values().length)
            return null;

        return ZoneType.values()[value];
    }

    public String getName() {
        return name;
    }

}
