package me.Logicism.OpenRGB4J.openrgb.entities;

public class OpenRGBSegment {

    private String name;

    private ZoneType type;

    private int startIndex;
    private int ledsLength;

    /**
     * Instantiates the OpenRGBSegment class
     *
     * @param name The segment name
     * @param type The segment type
     * @param startIndex The segment start index
     * @param ledsLength The segment LEDs count
     */
    public OpenRGBSegment(String name, ZoneType type, int startIndex, int ledsLength) {
        this.name = name;
        this.type = type;
        this.startIndex = startIndex;
        this.ledsLength = ledsLength;
    }

    /**
     * Returns the segment name
     *
     * @return The segment name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the segment type
     *
     * @return The segment type
     */
    public ZoneType getType() {
        return type;
    }

    /**
     * Returns the segment start index
     *
     * @return The segment start index
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Returns the segment LEDs count
     *
     * @return The segment LEDs count
     */
    public int getLEDsLength() {
        return ledsLength;
    }

    /**
     * The static Builder Class
     */
    public static class Builder {

        private String name;

        private ZoneType type;

        private int startIndex;
        private int ledsLength;

        /**
         * Sets the segment name
         *
         * @param name The segment name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Sets the segment type
         *
         * @param type The segment type
         */
        public void setType(ZoneType type) {
            this.type = type;
        }

        /**
         * Sets the segment start index
         *
         * @param startIndex The segment start index
         */
        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        /**
         * Sets the segment LEDs count
         *
         * @param ledsLength The segment LEDs count
         */
        public void setLEDsLength(int ledsLength) {
            this.ledsLength = ledsLength;
        }

        /**
         * Builds the Builder to a OpenRGBSegment object
         *
         * @return the OpenRGBSegment object
         */
        public OpenRGBSegment build() {
            return new OpenRGBSegment(name, type, startIndex, ledsLength);
        }
    }
}
