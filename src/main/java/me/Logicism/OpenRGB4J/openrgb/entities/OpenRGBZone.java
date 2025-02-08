package me.Logicism.OpenRGB4J.openrgb.entities;

import java.util.ArrayList;
import java.util.List;

public class OpenRGBZone {

    private ZoneType zoneType;

    private String name;

    private int ledsMin;
    private int ledsMax;
    private int ledsCount;
    private int matrixLength;
    private int matrixHeight;
    private int matrixWidth;
    private int zoneFlags;

    private int[][] matrixData;

    private List<OpenRGBSegment> segments;

    /**
     * Instantiates the OpenRGBZone class
     *
     * @param zoneType The zone type
     * @param name The zone name
     * @param ledsMin The zones minimum LEDs
     * @param ledsMax The zones maximum LEDs
     * @param ledsCount The zones LEDs count
     * @param matrixLength The zones matrix length
     * @param matrixHeight The zones matrix height
     * @param matrixWidth The zones matrix width
     * @param matrixData The zones matrix data in a double integer array
     * @param segments The zones matrix segments in a List
     * @param zoneFlags The zones flags
     */
    public OpenRGBZone(ZoneType zoneType, String name, int ledsMin, int ledsMax, int ledsCount, int matrixLength, int matrixHeight,
                       int matrixWidth, int[][] matrixData, List<OpenRGBSegment> segments, int zoneFlags) {
        this.zoneType = zoneType;
        this.name = name;
        this.ledsMin = ledsMin;
        this.ledsMax = ledsMax;
        this.ledsCount = ledsCount;
        this.matrixLength = matrixLength;
        this.matrixHeight = matrixHeight;
        this.matrixWidth = matrixWidth;
        this.matrixData = matrixData;
        this.segments = segments;
        this.zoneFlags = zoneFlags;
    }

    /**
     * Returns the zone type
     *
     * @return The zone type
     */
    public ZoneType getZoneType() {
        return zoneType;
    }

    /**
     * Returns the zone name
     *
     * @return The zone name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the zones minimum LEDs
     *
     * @return The zones minimum LEDs
     */
    public int getLedsMin() {
        return ledsMin;
    }

    /**
     * Returns the zones maximum LEDs
     *
     * @return The zones maximum LEDs
     */
    public int getLedsMax() {
        return ledsMax;
    }

    /**
     * Returns the zones LEDs count
     *
     * @return The zones LEDs count
     */
    public int getLedsCount() {
        return ledsCount;
    }

    /**
     * Returns the zones matrix length
     *
     * @return The zones matrix length
     */
    public int getMatrixLength() {
        return matrixLength;
    }

    /**
     * Returns the zones matrix height
     *
     * @return The zones matrix height
     */
    public int getMatrixHeight() {
        return matrixHeight;
    }


    /**
     * Returns the zones matrix width
     *
     * @return The zones matrix width
     */
    public int getMatrixWidth() {
        return matrixWidth;
    }

    /**
     * Returns the zones matrix data
     *
     * @return The zones matrix data
     */
    public int[][] getMatrixData() {
        return matrixData;
    }

    /**
     * The static Builder Class
     */
    public static class Builder {

        private ZoneType zoneType;

        private String name;

        private int ledsMin;
        private int ledsMax;
        private int ledsCount;
        private int matrixLength;
        private int matrixHeight;
        private int matrixWidth;
        private int zoneFlags;

        private int[][] matrixData;

        private List<OpenRGBSegment> segments = new ArrayList<>();

        /**
         * Sets the zone type
         *
         * @param zoneType The zone type
         */
        public void setZoneType(ZoneType zoneType) {
            this.zoneType = zoneType;
        }

        /**
         * Sets the zone name
         *
         * @param name The zone name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Sets the zones minimum LEDs
         *
         * @param ledsMin The zones minimum LEDs
         */
        public void setLedsMin(int ledsMin) {
            this.ledsMin = ledsMin;
        }

        /**
         * Sets the zones maximum LEDs
         *
         * @param ledsMax The zones maximum LEDs
         */
        public void setLedsMax(int ledsMax) {
            this.ledsMax = ledsMax;
        }

        /**
         * Sets the zones LEDs count
         *
         * @param ledsCount The zones LEDs count
         */
        public void setLedsCount(int ledsCount) {
            this.ledsCount = ledsCount;
        }

        /**
         * Sets the zones matrix length
         *
         * @param matrixLength The zones matrix length
         */
        public void setMatrixLength(int matrixLength) {
            this.matrixLength = matrixLength;
        }

        /**
         * Sets the zones matrix height
         *
         * @param matrixHeight The zones matrix height
         */
        public void setMatrixHeight(int matrixHeight) {
            this.matrixHeight = matrixHeight;
        }

        /**
         * Sets the zones matrix width
         *
         * @param matrixWidth The zones matrix width
         */
        public void setMatrixWidth(int matrixWidth) {
            this.matrixWidth = matrixWidth;
        }

        /**
         * Adds a zones segment
         *
         * @param segment The zones segment
         */
        public void addSegment(OpenRGBSegment segment) {
            segments.add(segment);
        }

        /**
         * Sets the zones flags
         *
         * @param zoneFlags The zones flags
         */
        public void setZoneFlags(int zoneFlags) {
            this.zoneFlags = zoneFlags;
        }

        /**
         * Builds the Builder to a OpenRGBZone object
         *
         * @return the OpenRGBZone object
         */
        public OpenRGBZone build() {
            return new OpenRGBZone(zoneType, name, ledsMin, ledsMax, ledsCount, matrixLength, matrixHeight, matrixWidth,
                    matrixData, segments, zoneFlags);
        }
    }
}
