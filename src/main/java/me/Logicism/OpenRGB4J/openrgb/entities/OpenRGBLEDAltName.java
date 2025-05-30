package me.Logicism.OpenRGB4J.openrgb.entities;

/**
 * The OpenRGBLEDAlternateName entity class
 */
public class OpenRGBLEDAltName {

    private String name;

    /**
     * Instantiates the OpenRGBLEDAlternate Class
     *
     * @param name  The LED Alternate name
     */
    public OpenRGBLEDAltName(String name) {
        this.name = name;
    }

    /**
     * Returns the OpenRGBLEDAlternate name
     *
     * @return The LED Alternate name
     */
    public String getName() {
        return name;
    }

    /**
     * The static Builder Class
     */
    public static class Builder {

        private String name;

        /**
         * Sets the LED Alternate name
         *
         * @param name The LED Alternate name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Builds the Builder to a OpenRGBLED object
         *
         * @return the OpenRGBLED object
         */
        public OpenRGBLEDAltName build() {
            return new OpenRGBLEDAltName(name);
        }

    }
}
