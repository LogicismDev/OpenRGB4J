package me.Logicism.OpenRGB4J.openrgb.entities;

public class OpenRGBSegment {

    private String name;

    private ZoneType type;

    private int startIndex;
    private int ledsLength;

    public OpenRGBSegment(String name, ZoneType type, int startIndex, int ledsLength) {
        this.name = name;
        this.type = type;
        this.startIndex = startIndex;
        this.ledsLength = ledsLength;
    }

    public String getName() {
        return name;
    }

    public ZoneType getType() {
        return type;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getLEDsLength() {
        return ledsLength;
    }

    public static class Builder {

        private String name;

        private ZoneType type;

        private int startIndex;
        private int ledsLength;

        public void setName(String name) {
            this.name = name;
        }

        public void setType(ZoneType type) {
            this.type = type;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public void setLEDsLength(int ledsLength) {
            this.ledsLength = ledsLength;
        }

        public OpenRGBSegment build() {
            return new OpenRGBSegment(name, type, startIndex, ledsLength);
        }
    }
}
