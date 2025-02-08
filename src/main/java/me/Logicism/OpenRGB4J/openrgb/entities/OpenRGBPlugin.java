package me.Logicism.OpenRGB4J.openrgb.entities;

public class OpenRGBPlugin {

    private String name;
    private String description;
    private String version;

    private int index;
    private int protocolVersion;

    public OpenRGBPlugin(String name, String description, String version, int index, int protocolVersion) {
        this.name = name;
        this.description = description;
        this.version = version;
        this.index = index;
        this.protocolVersion = protocolVersion;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }

    public int getIndex() {
        return index;
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }

    public static class Builder {

        private String name;
        private String description;
        private String version;

        private int index;
        private int protocolVersion;

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setProtocolVersion(int protocolVersion) {
            this.protocolVersion = protocolVersion;
        }

        public OpenRGBPlugin build() {
            return new OpenRGBPlugin(name, description, version, index, protocolVersion);
        }
    }

}
