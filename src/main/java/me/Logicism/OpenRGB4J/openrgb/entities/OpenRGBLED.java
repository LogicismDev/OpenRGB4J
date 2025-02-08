package me.Logicism.OpenRGB4J.openrgb.entities;

/**
 * The OpenRGBLED entity class
 */
public class OpenRGBLED {

    private String name;

    private int value;

    /**
     * Instantiates the OpenRGBLED Class
     *
     * @param name  The LED name
     * @param value The LED value
     */
    public OpenRGBLED(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Returns the OpenRGBLED name
     *
     * @return The LED name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the OpenRGBLED value
     *
     * @return The LED value
     */
    public int getValue() {
        return value;
    }

    /**
     * The static Builder Class
     */
    public static class Builder {

        private String name;

        private int value;

        /**
         * Sets the LED name
         *
         * @param name The LED name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Sets the LED value
         *
         * @param value The LED value
         */
        public void setValue(int value) {
            this.value = value;
        }

        /**
         * Builds the Builder to a OpenRGBLED object
         *
         * @return the OpenRGBLED object
         */
        public OpenRGBLED build() {
            return new OpenRGBLED(name, value);
        }

    }
}
