package me.Logicism.OpenRGB4J.openrgb.entities;

public class OpenRGBPlugin {

    private String name;
    private String description;
    private String version;

    private int index;
    private int protocolVersion;

    /**
     * Instantiates the OpenRGBPlugin class
     *
     * @param name The plugin name
     * @param description The plugin description
     * @param version The plugin version
     * @param index The plugin index
     * @param protocolVersion The plugin protocol version
     */
    public OpenRGBPlugin(String name, String description, String version, int index, int protocolVersion) {
        this.name = name;
        this.description = description;
        this.version = version;
        this.index = index;
        this.protocolVersion = protocolVersion;
    }

    /**
     * Returns the plugin name
     *
     * @return The plugin name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the plugin description
     *
     * @return The plugin description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the plugin version
     *
     * @return The plugin version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Returns the plugin index
     *
     * @return The plugin index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the protocol version
     *
     * @return The protocol version
     */
    public int getProtocolVersion() {
        return protocolVersion;
    }

    /**
     * The static Builder Class
     */
    public static class Builder {

        private String name;
        private String description;
        private String version;

        private int index;
        private int protocolVersion;

        /**
         * Sets the plugin name
         *
         * @param name The plugin name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Sets the plugin description
         *
         * @param description The plugin description
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * Sets the plugin version
         *
         * @param version The plugin version
         */
        public void setVersion(String version) {
            this.version = version;
        }

        /**
         * Sets the plugin index
         *
         * @param index The plugin index
         */
        public void setIndex(int index) {
            this.index = index;
        }

        /**
         * Sets the plugin protocol version
         *
         * @param protocolVersion The plugin protocol version
         */
        public void setProtocolVersion(int protocolVersion) {
            this.protocolVersion = protocolVersion;
        }

        /**
         * Builds the Builder to a OpenRGBPlugin object
         *
         * @return the OpenRGBPlugin object
         */
        public OpenRGBPlugin build() {
            return new OpenRGBPlugin(name, description, version, index, protocolVersion);
        }
    }

}
