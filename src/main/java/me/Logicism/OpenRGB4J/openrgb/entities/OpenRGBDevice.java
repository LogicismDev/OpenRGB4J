package me.Logicism.OpenRGB4J.openrgb.entities;

import java.util.ArrayList;
import java.util.List;

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

    public OpenRGBDevice(DeviceType type, String name, String vendorName, String description, String version,
                         String serial, String location, List<OpenRGBMode> modes, List<OpenRGBZone> zones,
                         List<OpenRGBLED> leds, List<OpenRGBColor> colors) {
        this.type = type;
        this.name = name;
        this.vendorName = vendorName;
        this.description = description;
        this.version = version;
        this.serial = serial;
        this.location = location;
        this.modes = modes;
        this.zones = zones;
        this.leds = leds;
        this.colors = colors;
    }

    public DeviceType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }

    public String getSerial() {
        return serial;
    }

    public String getLocation() {
        return location;
    }

    public OpenRGBMode getMode() {
        return mode;
    }

    public List<OpenRGBMode> getModes() {
        return modes;
    }

    public List<OpenRGBZone> getZones() {
        return zones;
    }

    public List<OpenRGBLED> getLEDs() {
        return leds;
    }

    public List<OpenRGBColor> getColors() {
        return colors;
    }

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

       public void setOpenRGBType(DeviceType type) {
            this.type = type;
        }

       public void setName(String name) {
            this.name = name;
        }

       public void setVendorName(String vendorName) {
            this.vendorName = vendorName;
        }

       public void setDescription(String description) {
            this.description = description;
        }

       public void setVersion(String version) {
            this.version = version;
        }

       public void setSerial(String serial) {
            this.serial = serial;
        }

       public void setLocation(String location) {
            this.location = location;
        }

       public void setMode(OpenRGBMode mode) {
            this.mode = mode;
        }

       public void addMode(OpenRGBMode mode) {
            this.modes.add(mode);
        }

       public void addZone(OpenRGBZone zone) {
            this.zones.add(zone);
        }

       public void addLED(OpenRGBLED led) {
            this.leds.add(led);
        }

       public void addColor(OpenRGBColor color) {
            this.colors.add(color);
        }

        public OpenRGBDevice build() {
            return new OpenRGBDevice(type, name, vendorName, description, version, serial, location, modes, zones, leds, colors);
        }

    }
}
