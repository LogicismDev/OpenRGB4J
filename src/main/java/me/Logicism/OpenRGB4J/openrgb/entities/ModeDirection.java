package me.Logicism.OpenRGB4J.openrgb.entities;

/**
 * The ModeDirection enum class
 */
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

    /**
     * Parses an integer value to a ModeDirection enum
     *
     * @param value The value of the ModeDirection enum
     * @return The DeviceType enum
     */
    public static ModeDirection parseValue(int value) {
        if (value >= ModeDirection.values().length)
            return null;

        return ModeDirection.values()[value];
    }

    /**
     * Retrieves the name associated with the DeviceType enum
     *
     * @return The ModeDirection Name
     */
    public String getName() {
        return name;
    }
}
