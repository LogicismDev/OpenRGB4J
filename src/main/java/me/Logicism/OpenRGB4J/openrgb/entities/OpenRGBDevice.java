package me.Logicism.OpenRGB4J.openrgb.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * The OpenRGBDevice entity Class
 */
public class OpenRGBDevice {

    private DeviceType type;

    private String name;
    private String vendorName;
    private String description;
    private String version;
    private String serial;
    private String location;

    private OpenRGBMode mode;

    private List<OpenRGBMode> modes;
    private List<OpenRGBZone> zones;
    private List<OpenRGBLED> leds;
    private List<OpenRGBColor> colors;

    /**
     * Instantiates the OpenRGBDevice Class
     *
     * @param type        The DeviceType enum
     * @param name        The device name
     * @param vendorName  The device vendor name
     * @param description The device description
     * @param version     The device version
     * @param serial      The device serial
     * @param location    The device location
     * @param mode        The devices current mode
     * @param modes       The devices available modes in a List
     * @param zones       The devices zones in a List
     * @param leds        The devices LEDs in a List
     * @param colors      The devices colors in a List
     */
    public OpenRGBDevice(DeviceType type, String name, String vendorName, String description, String version,
                         String serial, String location, OpenRGBMode mode, List<OpenRGBMode> modes, List<OpenRGBZone> zones,
                         List<OpenRGBLED> leds, List<OpenRGBColor> colors) {
        this.type = type;
        this.name = name;
        this.vendorName = vendorName;
        this.description = description;
        this.version = version;
        this.serial = serial;
        this.location = location;
        this.mode = mode;
        this.modes = modes;
        this.zones = zones;
        this.leds = leds;
        this.colors = colors;
    }

    /**
     * Returns the DeviceType enum
     *
     * @return The DeviceType enum
     */
    public DeviceType getType() {
        return type;
    }

    /**
     * Returns the device name
     *
     * @return The device name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the device vendor name
     *
     * @return The device vendor name
     */
    public String getVendorName() {
        return vendorName;
    }

    /**
     * Returns the device description
     *
     * @return The device description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the device version
     *
     * @return The device version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Returns the device serial
     *
     * @return The device serial
     */
    public String getSerial() {
        return serial;
    }

    /**
     * Returns the device location
     *
     * @return The device location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Returns the devices current mode
     *
     * @return The devices current mode
     */
    public OpenRGBMode getMode() {
        return mode;
    }

    /**
     * Returns the devices available modes
     *
     * @return The devices available modes
     */
    public List<OpenRGBMode> getModes() {
        return modes;
    }

    /**
     * Returns the devices available zones
     *
     * @return The devices available zones
     */
    public List<OpenRGBZone> getZones() {
        return zones;
    }

    /**
     * Returns the devices available LEDs
     *
     * @return The devices available LEDs
     */
    public List<OpenRGBLED> getLEDs() {
        return leds;
    }

    /**
     * Returns the devices available colors
     *
     * @return The devices available colors
     */
    public List<OpenRGBColor> getColors() {
        return colors;
    }

    /**
     * The static Builder Class
     */
    public static class Builder {

        private DeviceType type;

        private String name;
        private String vendorName;
        private String description;
        private String version;
        private String serial;
        private String location;

        private OpenRGBMode mode;

        private List<OpenRGBMode> modes = new ArrayList<>();
        private List<OpenRGBZone> zones = new ArrayList<>();
        private List<OpenRGBLED> leds = new ArrayList<>();
        private List<OpenRGBColor> colors = new ArrayList<>();

        /**
         * Sets the DeviceType enum
         *
         * @param type The DeviceType enum
         */
        public void setOpenRGBType(DeviceType type) {
            this.type = type;
        }

        /**
         * Sets the device name
         *
         * @param name The device name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Sets the device name
         *
         * @param vendorName The device vendor name
         */
        public void setVendorName(String vendorName) {
            this.vendorName = vendorName;
        }

        /**
         * Sets the device name
         *
         * @param description The device description
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * Sets the device version
         *
         * @param version The device version
         */
        public void setVersion(String version) {
            this.version = version;
        }

        /**
         * Sets the device serial
         *
         * @param serial The device serial
         */
        public void setSerial(String serial) {
            this.serial = serial;
        }

        /**
         * Sets the device location
         *
         * @param location The device location
         */
        public void setLocation(String location) {
            this.location = location;
        }

        /**
         * Sets the devices current mode
         *
         * @param mode The devices current mode
         */
        public void setMode(OpenRGBMode mode) {
            this.mode = mode;
        }

        /**
         * Add the devices available mode
         *
         * @param mode The devices available mode
         */
        public void addMode(OpenRGBMode mode) {
            this.modes.add(mode);
        }

        /**
         * Add the devices available zone
         *
         * @param zone The devices available zone
         */
        public void addZone(OpenRGBZone zone) {
            this.zones.add(zone);
        }

        /**
         * Add the devices available LED
         *
         * @param led The devices available LED
         */
        public void addLED(OpenRGBLED led) {
            this.leds.add(led);
        }

        /**
         * Add the devices current color
         *
         * @param color The devices current color
         */
        public void addColor(OpenRGBColor color) {
            this.colors.add(color);
        }

        /**
         * Builds the Builder into a OpenRGBDevice object
         *
         * @return The OpenRGBDevice object
         */
        public OpenRGBDevice build() {
            return new OpenRGBDevice(type, name, vendorName, description, version, serial, location, mode, modes, zones, leds, colors);
        }

    }
}
