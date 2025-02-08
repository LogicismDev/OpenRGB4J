package me.Logicism.OpenRGB4J.openrgb.entities;

/**
 * The ModeColorType enum class
 */
public enum ModeColorType {
    NONE("None"),
    PER_LED("Per LED"),
    MODE_SPECIFIC("Mode Specific"),
    RANDOM("Random");

    private String name;

    ModeColorType(String name) {
        this.name = name;
    }

    /**
     * Parses an integer value to a ModeColorType enum
     *
     * @param value The value of the ModeColorType enum
     * @return The ModeColorType enum
     */
    public static ModeColorType parseValue(int value) {
        if (value >= ModeColorType.values().length)
            return null;

        return ModeColorType.values()[value];
    }

    /**
     * Retrieves the name associated with the DeviceType enum
     *
     * @return The ModeColorType Name
     */
    public String getName() {
        return name;
    }
}
