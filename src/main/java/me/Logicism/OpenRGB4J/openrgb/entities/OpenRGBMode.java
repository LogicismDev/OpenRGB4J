package me.Logicism.OpenRGB4J.openrgb.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * The OpenRGBMode entity class
 */
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

    /**
     * Instantiates the OpenRGBMode class
     *
     * @param name The mode name
     * @param value The mode value
     * @param flags The mode flags
     * @param speedMin The minimum mode speed
     * @param speedMax The maximum mode speed
     * @param brightnessMin The minimum mode brightness
     * @param brightnessMax The maximum mode brightness
     * @param colorsMin The minimum mode colors
     * @param colorsMax The maximum mode colors
     * @param speed The mode speed
     * @param brightness The mode brightness
     * @param direction The mode direction
     * @param colorType The mode color type
     * @param colors The mode colors
     */
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

    /**
     * Returns the mode name
     *
     * @return The mode name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the mode value
     *
     * @return The mode value
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the modes flags
     *
     * @return The modes flags
     */
    public int getFlags() {
        return flags;
    }

    /**
     * Returns the modes minimum speed
     *
     * @return The modes minimum speed
     */
    public int getSpeedMin() {
        return speedMin;
    }

    /**
     * Returns the modes maximum speed
     *
     * @return The modes maximum speed
     */
    public int getSpeedMax() {
        return speedMax;
    }

    /**
     * Returns the modes minimum brightness
     *
     * @return The modes minimum brightness
     */
    public int getBrightnessMin() {
        return brightnessMin;
    }

    /**
     * Returns the modes maximum brightness
     *
     * @return The modes maximum brightness
     */
    public int getBrightnessMax() {
        return brightnessMax;
    }

    /**
     * Returns the modes minimum colors
     *
     * @return The modes minimum colors
     */
    public int getColorsMin() {
        return colorsMin;
    }

    /**
     * Returns the modes maximum colors
     *
     * @return The modes maximum colors
     */
    public int getColorsMax() {
        return colorsMax;
    }

    /**
     * Returns the modes speed
     *
     * @return The modes speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Returns the modes brightness
     *
     * @return The modes brightness
     */
    public int getBrightness() {
        return brightness;
    }

    /**
     * Returns the modes direction
     *
     * @return The modes direction
     */
    public ModeDirection getDirection() {
        return direction;
    }

    /**
     * Returns the modes color type
     *
     * @return The modes color type
     */
    public ModeColorType getColorType() {
        return colorType;
    }

    /**
     * Returns the modes colors
     *
     * @return The modes colors
     */
    public List<OpenRGBColor> getColors() {
        return colors;
    }

    /**
     * The static Builder Class
     */
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

        /**
         * Sets the mode name
         *
         * @param name The mode name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Sets the mode value
         *
         * @param value The mode value
         */
        public void setValue(int value) {
            this.value = value;
        }

        /**
         * Sets the modes flags
         *
         * @param flags The modes flags
         */
        public void setFlags(int flags) {
            this.flags = flags;
        }

        /**
         * Sets the modes minimum speed
         *
         * @param speedMin The modes minimum speed
         */
        public void setSpeedMin(int speedMin) {
            this.speedMin = speedMin;
        }

        /**
         * Sets the modes maximum speed
         *
         * @param speedMax The modes maximum speed
         */
        public void setSpeedMax(int speedMax) {
            this.speedMax = speedMax;
        }

        /**
         * Sets the modes minimum brightness
         *
         * @param brightnessMin The modes minimum brightness
         */
        public void setBrightnessMin(int brightnessMin) {
            this.brightnessMin = brightnessMin;
        }

        /**
         * Sets the modes maximum speed
         *
         * @param brightnessMax The modes minimum speed
         */
        public void setBrightnessMax(int brightnessMax) {
            this.brightnessMax = brightnessMax;
        }

        /**
         * Sets the modes minimum colors
         *
         * @param colorsMin The modes minimum colors
         */
        public void setColorsMin(int colorsMin) {
            this.colorsMin = colorsMin;
        }

        /**
         * Sets the modes maximum colors
         *
         * @param colorsMax The modes maximum colors
         */
        public void setColorsMax(int colorsMax) {
            this.colorsMax = colorsMax;
        }

        /**
         * Sets the modes speed
         *
         * @param speed The modes speed
         */
        public void setSpeed(int speed) {
            this.speed = speed;
        }

        /**
         * Sets the modes brightness
         *
         * @param brightness The modes brightness
         */
        public void setBrightness(int brightness) {
            this.brightness = brightness;
        }

        /**
         * Sets the modes direction
         *
         * @param direction The modes direction
         */
        public void setDirection(ModeDirection direction) {
            this.direction = direction;
        }

        /**
         * Sets the modes color type
         *
         * @param colorType The modes color type
         */
        public void setColorType(ModeColorType colorType) {
            this.colorType = colorType;
        }

        /**
         * Adds the modes color
         *
         * @param color The modes color
         */
        public void addColor(OpenRGBColor color) {
            colors.add(color);
        }

        /**
         * Builds the Builder to a OpenRGBMode object
         *
         * @return the OpenRGBMode object
         */
        public OpenRGBMode build() {
            return new OpenRGBMode(name, value, flags, speedMin, speedMax, brightnessMin, brightnessMax, colorsMin,
                    colorsMax, speed, brightness, direction, colorType, colors);
        }
    }
}
