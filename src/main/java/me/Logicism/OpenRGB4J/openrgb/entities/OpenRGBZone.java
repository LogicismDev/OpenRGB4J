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

    public ZoneType getZoneType() {
        return zoneType;
    }

    public String getName() {
        return name;
    }

    public int getLedsMin() {
        return ledsMin;
    }

    public int getLedsMax() {
        return ledsMax;
    }

    public int getLedsCount() {
        return ledsCount;
    }

    public int getMatrixLength() {
        return matrixLength;
    }

    public int getMatrixHeight() {
        return matrixHeight;
    }

    public int getMatrixWidth() {
        return matrixWidth;
    }

    public int[][] getMatrixData() {
        return matrixData;
    }

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

        public void setZoneType(ZoneType zoneType) {
            this.zoneType = zoneType;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLedsMin(int ledsMin) {
            this.ledsMin = ledsMin;
        }

        public void setLedsMax(int ledsMax) {
            this.ledsMax = ledsMax;
        }

        public void setLedsCount(int ledsCount) {
            this.ledsCount = ledsCount;
        }

        public void setMatrixLength(int matrixLength) {
            this.matrixLength = matrixLength;
        }

        public void setMatrixHeight(int matrixHeight) {
            this.matrixHeight = matrixHeight;
        }

        public void setMatrixWidth(int matrixWidth) {
            this.matrixWidth = matrixWidth;
        }

        public void addSegment(OpenRGBSegment segment) {
            segments.add(segment);
        }

        public void setZoneFlags(int zoneFlags) {
            this.zoneFlags = zoneFlags;
        }

        public OpenRGBZone build() {
            return new OpenRGBZone(zoneType, name, ledsMin, ledsMax, ledsCount, matrixLength, matrixHeight, matrixWidth,
                    matrixData, segments, zoneFlags);
        }
    }
}
