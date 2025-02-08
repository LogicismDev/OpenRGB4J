package me.Logicism.OpenRGB4J.openrgb.entities;

import java.util.ArrayList;
import java.util.List;

public class OpenRGBMode {

    private String name;

    private int value;
    private int flags;
    private int speedMin;
    private int speedMax;
    private int brightnessMin;
    private int brightnessMax;
    private int colorsMin;
    private int colorsMax;
    private int speed;
    private int brightness;

    private ModeDirection direction;
    private ModeColorType colorType;

    private List<OpenRGBColor> colors;

    public OpenRGBMode(String name, int value, int flags, int speedMin, int speedMax, int brightnessMin,
                       int brightnessMax, int colorsMin, int colorsMax, int speed, int brightness,
                       ModeDirection direction, ModeColorType colorType, List<OpenRGBColor> colors) {
        this.name = name;
        this.value = value;
        this.flags = flags;
        this.speedMin = speedMin;
        this.speedMax = speedMax;
        this.brightnessMin = brightnessMin;
        this.brightnessMax = brightnessMax;
        this.colorsMin = colorsMin;
        this.colorsMax = colorsMax;
        this.speed = speed;
        this.brightness = brightness;
        this.direction = direction;
        this.colorType = colorType;
        this.colors = colors;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getFlags() {
        return flags;
    }

    public int getSpeedMin() {
        return speedMin;
    }

    public int getSpeedMax() {
        return speedMax;
    }

    public int getBrightnessMin() {
        return brightnessMin;
    }

    public int getBrightnessMax() {
        return brightnessMax;
    }

    public int getColorsMin() {
        return colorsMin;
    }

    public int getColorsMax() {
        return colorsMax;
    }

    public int getSpeed() {
        return speed;
    }

    public int getBrightness() {
        return brightness;
    }

    public ModeDirection getDirection() {
        return direction;
    }

    public ModeColorType getColorType() {
        return colorType;
    }

    public List<OpenRGBColor> getColors() {
        return colors;
    }

    public static class Builder {

        private String name;
        private int value;
        private int flags;
        private int speedMin;
        private int speedMax;
        private int brightnessMin;
        private int brightnessMax;
        private int colorsMin;
        private int colorsMax;
        private int speed;
        private int brightness;
        private ModeDirection direction;
        private ModeColorType colorType;
        private List<OpenRGBColor> colors = new ArrayList<>();

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setFlags(int flags) {
            this.flags = flags;
        }

        public void setSpeedMin(int speedMin) {
            this.speedMin = speedMin;
        }

        public void setSpeedMax(int speedMax) {
            this.speedMax = speedMax;
        }

        public void setBrightnessMin(int brightnessMin) {
            this.brightnessMin = brightnessMin;
        }

        public void setBrightnessMax(int brightnessMax) {
            this.brightnessMax = brightnessMax;
        }

        public void setColorsMin(int colorsMin) {
            this.colorsMin = colorsMin;
        }

        public void setColorsMax(int colorsMax) {
            this.colorsMax = colorsMax;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public void setBrightness(int brightness) {
            this.brightness = brightness;
        }

        public void setDirection(ModeDirection direction) {
            this.direction = direction;
        }

        public void setColorType(ModeColorType colorType) {
            this.colorType = colorType;
        }

        public void addColor(OpenRGBColor color) {
            colors.add(color);
        }

        public OpenRGBMode build() {
            return new OpenRGBMode(name, value, flags, speedMin, speedMax, brightnessMin, brightnessMax, colorsMin,
                    colorsMax, speed, brightness, direction, colorType, colors);
        }
    }
}
