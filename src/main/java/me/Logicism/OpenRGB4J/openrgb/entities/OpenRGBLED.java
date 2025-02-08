package me.Logicism.OpenRGB4J.openrgb.entities;

public class OpenRGBLED {

    private String name;

    private int value;

    public OpenRGBLED(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static class Builder {

        private String name;

        private int value;

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public OpenRGBLED build() {
            return new OpenRGBLED(name, value);
        }

    }
}
