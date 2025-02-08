package me.Logicism.OpenRGB4J.openrgb.entities;

/**
 * The DeviceType enum class
 */
public enum DeviceType {
    MOTHERBOARD("Motherboard"),
    DRAM("DRAM"),
    GPU("GPU"),
    COOLER("Cooler"),
    LED_STRIP("LED Strip"),
    KEYBOARD("Keyboard"),
    MOUSE("Mouse"),
    MOUSE_MAT("Mouse Mat"),
    HEADSET("Headset"),
    HEADSET_STAND("Headset Stand"),
    GAMEPAD("Gamepad"),
    LIGHT("Light"),
    SPEAKER("Speaker"),
    VIRTUAL("Virtual"),
    STORAGE("Storage"),
    CASE("Case"),
    MICROPHONE("Microphone"),
    ACCESSORY("Accessory"),
    KEYPAD("Keypad"),
    UNKNOWN("Unknown");

    private String name;

    DeviceType(String name) {
        this.name = name;
    }

    /**
     * Parses an integer value to a DeviceType enum
     *
     * @param value The value of the DeviceType enum
     * @return The DeviceType enum
     */
    public static DeviceType parseValue(int value) {
        if (value >= DeviceType.values().length)
            return UNKNOWN;

        return DeviceType.values()[value];
    }

    /**
     * Retrieves the name associated with the DeviceType enum
     *
     * @return The DeviceType Name
     */
    public String getName() {
        return name;
    }
}
