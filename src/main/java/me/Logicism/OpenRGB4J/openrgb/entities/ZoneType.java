package me.Logicism.OpenRGB4J.openrgb.entities;

public enum ZoneType {
    SINGLE("Single"),
    LINEAR("Linear"),
    MATRIX("Matrix");

    private String name;

    ZoneType(String name) {
        this.name = name;
    }

    /**
     * Parses an integer value to a ZoneType enum
     *
     * @param value The value of the ZoneType enum
     * @return The ZoneType enum
     */
    public static ZoneType parseValue(int value) {
        if (value >= ZoneType.values().length)
            return null;

        return ZoneType.values()[value];
    }

    /**
     * Retrieves the name associated with the DeviceType enum
     *
     * @return The ZoneType Name
     */
    public String getName() {
        return name;
    }

}
