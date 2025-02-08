package me.Logicism.OpenRGB4J.openrgb.entities;

public enum ModeColorType {
    NONE("None"),
    PER_LED("Per LED"),
    MODE_SPECIFIC("Mode Specific"),
    RANDOM("Random");

    private String name;

    ModeColorType(String name) {
        this.name = name;
    }

    public static ModeColorType parseValue(int value) {
        if (value >= ModeColorType.values().length)
            return null;

        return ModeColorType.values()[value];
    }

    public String getName() {
        return name;
    }
}
