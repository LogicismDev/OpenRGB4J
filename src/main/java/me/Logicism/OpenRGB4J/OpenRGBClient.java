package me.Logicism.OpenRGB4J;

import me.Logicism.OpenRGB4J.openrgb.OpenRGBPacket;
import me.Logicism.OpenRGB4J.openrgb.entities.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class OpenRGBClient {

    private String ip;
    private int port;
    private String clientID;

    private int protocolVersion;

    private Socket socket;
    private BufferedInputStream in;
    private BufferedOutputStream out;

    private ReentrantLock socketLock = new ReentrantLock();

    public OpenRGBClient(String ip, int port, String clientID) {
        this.ip = ip;
        this.port = port;
        this.clientID = clientID;
    }

    public void connect() throws IOException {
        socket = new Socket();
        socket.connect(new InetSocketAddress(ip, port));
        this.in = new BufferedInputStream(socket.getInputStream());
        this.out = new BufferedOutputStream(socket.getOutputStream());
        this.protocolVersion = getProtocolVersion();
        sendMessage(OpenRGBPacket.NET_PACKET_ID_SET_CLIENT_NAME, 0, (clientID + '\u0000').getBytes(StandardCharsets.US_ASCII));
    }

    public void disconnect() throws IOException {
        if (socket != null && !socket.isClosed() && socket.isConnected()) {
            socket.close();
        }
    }

    public int getControllerCount() throws IOException {
        socketLock.lock();

        try {
            sendMessage(OpenRGBPacket.NET_PACKET_ID_REQUEST_CONTROLLER_COUNT, 0, null);
            return read().getInt();
        } finally {
            socketLock.unlock();
        }
    }

    public OpenRGBDevice getDeviceController(int deviceIndex) throws IOException {
        socketLock.lock();
        try {
            byte[] data = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(protocolVersion).array();
            sendMessage(OpenRGBPacket.NET_PACKET_ID_REQUEST_CONTROLLER_DATA, deviceIndex, data);

            ByteBuffer buffer = read();

            // Unused Data Length
            int dataLength = Byte.toUnsignedInt(buffer.get());

            OpenRGBDevice.Builder deviceBuilder = new OpenRGBDevice.Builder();

            int rawRGBType = buffer.getInt();
            DeviceType type = DeviceType.parseValue(rawRGBType);
            deviceBuilder.setOpenRGBType(type);

            String name = readASCII(buffer);
            deviceBuilder.setName(name);
            String vendor = readASCII(buffer);
            deviceBuilder.setName(vendor);
            String description = readASCII(buffer);
            deviceBuilder.setName(description);
            String version = readASCII(buffer);
            deviceBuilder.setName(version);
            String serial = readASCII(buffer);
            deviceBuilder.setName(serial);
            String location = readASCII(buffer);
            deviceBuilder.setName(location);

            int modesLength = readUnsignedShort(buffer);
            int activeMode = buffer.getInt();

            for (int i = 0; i < modesLength; i++) {
                OpenRGBMode mode = readMode(buffer);
                deviceBuilder.addMode(mode);

                if (i == activeMode) {
                    deviceBuilder.setMode(mode);
                }
            }

            int zonesLength = readUnsignedShort(buffer);

            for (int i = 0; i < zonesLength; i++) {
                OpenRGBZone zone = readZone(buffer);
                deviceBuilder.addZone(zone);
            }

            int ledsLength = readUnsignedShort(buffer);

            for (int i = 0; i < ledsLength; i++) {
                OpenRGBLED led = readLED(buffer);
                deviceBuilder.addLED(led);
            }

            int colorsLength = readUnsignedShort(buffer);

            for (int i = 0; i < colorsLength; i++) {
                OpenRGBColor color = readRGBColor(buffer);
                deviceBuilder.addColor(color);
            }

            return deviceBuilder.build();
        } finally {
            socketLock.unlock();
        }
    }

    public int getProtocolVersion() throws IOException {
        socketLock.lock();

        try {
            sendMessage(OpenRGBPacket.NET_PACKET_ID_REQUEST_PROTOCOL_VERSION, 0, null);
            return read().getInt();
        } finally {
            socketLock.unlock();
        }
    }

    public List<String> getProfileList() throws IOException {
        socketLock.lock();

        try {
            List<String> profileList = new ArrayList<>();

            sendMessage(OpenRGBPacket.NET_PACKET_ID_REQUEST_PROFILE_LIST, 0, null);

            ByteBuffer buffer = read();

            // Unused Data Length
            int dataLength = Byte.toUnsignedInt(buffer.get());
            int numProfiles = readUnsignedShort(buffer);

            for (int i = 0; i < numProfiles; i++) {
                int profileNameLength = readUnsignedShort(buffer);

                String name = readASCII(buffer);
                profileList.add(name);
            }

            return profileList;
        } finally {
            socketLock.unlock();
        }
    }

    public void saveProfile(String name) throws IOException {
        socketLock.lock();

        try {
            sendMessage(OpenRGBPacket.NET_PACKET_ID_REQUEST_SAVE_PROFILE, 0,
                    ByteBuffer.allocate(name.length()).order(ByteOrder.LITTLE_ENDIAN)
                            .put(name.getBytes(StandardCharsets.US_ASCII)).array());
        } finally {
            socketLock.unlock();
        }
    }

    public void loadProfile(String name) throws IOException {
        socketLock.lock();

        try {
            sendMessage(OpenRGBPacket.NET_PACKET_ID_REQUEST_LOAD_PROFILE, 0,
                    ByteBuffer.allocate(name.length()).order(ByteOrder.LITTLE_ENDIAN)
                            .put(name.getBytes(StandardCharsets.US_ASCII)).array());
        } finally {
            socketLock.unlock();
        }
    }

    public void deleteProfile(String name) throws IOException {
        socketLock.lock();

        try {
            sendMessage(OpenRGBPacket.NET_PACKET_ID_REQUEST_DELETE_PROFILE, 0,
                    ByteBuffer.allocate(name.length()).order(ByteOrder.LITTLE_ENDIAN)
                            .put(name.getBytes(StandardCharsets.US_ASCII)).array());
        } finally {
            socketLock.unlock();
        }
    }

    public List<OpenRGBPlugin> getPluginList() throws IOException {
        socketLock.lock();

        try {
            List<OpenRGBPlugin> pluginList = new ArrayList<>();

            sendMessage(OpenRGBPacket.NET_PACKET_ID_REQUEST_PLUGIN_LIST, 0, null);

            ByteBuffer buffer = read();

            // Unused Data Length
            int dataLength = Byte.toUnsignedInt(buffer.get());
            int numPlugins = readUnsignedShort(buffer);

            for (int i = 0; i < numPlugins; i++) {
                OpenRGBPlugin plugin = readPlugin(buffer);

                pluginList.add(plugin);
            }

            return pluginList;
        } finally {
            socketLock.unlock();
        }
    }

    public void resizeZone(int deviceIndex, int zoneIndex, int newSize) throws IOException {
        socketLock.lock();

        try {
            sendMessage(OpenRGBPacket.NET_PACKET_ID_RGBCONTROLLER_RESIZEZONE, deviceIndex,
                    ByteBuffer.allocate(8).putInt(zoneIndex).putInt(newSize).array());
        } finally {
            socketLock.unlock();
        }
    }

    public void clearSegments(int deviceIndex, int startIndex) throws IOException {
        socketLock.lock();

        try {
            sendMessage(OpenRGBPacket.NET_PACKET_ID_RGBCONTROLLER_CLEARSEGMENTS, deviceIndex,
                    ByteBuffer.allocate(4).putInt(startIndex).array());
        } finally {
            socketLock.unlock();
        }
    }

    public void addSegment(int deviceIndex, int zoneIndex, OpenRGBSegment segment) throws IOException {
        socketLock.lock();

        try {
            int length = 22;
            length += segment.getName().length();

            sendMessage(OpenRGBPacket.NET_PACKET_ID_RGBCONTROLLER_ADDSEGMENT, deviceIndex,
                    ByteBuffer.allocate(length).putInt(Byte.toUnsignedInt((byte) length))
                            .putInt(Byte.toUnsignedInt((byte) zoneIndex))
                            .putInt((short) segment.getName().length() & 0xFF)
                            .put(segment.getName().getBytes(StandardCharsets.US_ASCII))
                            .putInt(segment.getType().ordinal())
                            .putInt(Byte.toUnsignedInt((byte) segment.getStartIndex()))
                            .putInt(Byte.toUnsignedInt((byte) segment.getLEDsLength())).array());
        } finally {
            socketLock.unlock();
        }
    }

    public void updateLEDs(int deviceIndex, int zoneIndex, List<OpenRGBColor> colors) throws IOException {
        socketLock.lock();

        try {
            int length = 10;
            length += 4 * colors.size();

            ByteBuffer buffer = ByteBuffer.allocate(length).putInt(Byte.toUnsignedInt((byte) length))
                    .putInt(Byte.toUnsignedInt((byte) zoneIndex))
                    .putInt((short) colors.size() & 0xFF);

            for (OpenRGBColor color : colors) {
                buffer.putInt((byte) color.getRed());
                buffer.putInt((byte) color.getGreen());
                buffer.putInt((byte) color.getBlue());
                buffer.putInt((byte) color.getAlpha());
            }

            sendMessage(OpenRGBPacket.NET_PACKET_ID_RGBCONTROLLER_UPDATELEDS, deviceIndex,
                    buffer.array());
        } finally {
            socketLock.unlock();
        }
    }

    public void updateLED(int deviceIndex, int ledIndex, OpenRGBColor color) throws IOException {
        socketLock.lock();

        try {
            int length = 14;

            ByteBuffer buffer = ByteBuffer.allocate(length).putInt(Byte.toUnsignedInt((byte) length))
                    .putInt(Byte.toUnsignedInt((byte) ledIndex));

            buffer.putInt((byte) color.getRed());
            buffer.putInt((byte) color.getGreen());
            buffer.putInt((byte) color.getBlue());
            buffer.putInt((byte) color.getAlpha());

            sendMessage(OpenRGBPacket.NET_PACKET_ID_RGBCONTROLLER_UPDATESINGLELED, deviceIndex,
                    buffer.array());
        } finally {
            socketLock.unlock();
        }
    }

    public void setCustomMode(int deviceIndex) throws IOException {
        socketLock.lock();

        try {
            sendMessage(OpenRGBPacket.NET_PACKET_ID_RGBCONTROLLER_SETCUSTOMMODE, deviceIndex, null);
        } finally {
            socketLock.unlock();
        }
    }

    public void updateMode(int deviceIndex, int modeIndex, OpenRGBMode mode) throws IOException {
        socketLock.lock();

        try {
            int length = 60;
            length += mode.getName().length();
            length += 4 * mode.getColors().size();

            ByteBuffer buffer = ByteBuffer.allocate(length).putInt(Byte.toUnsignedInt((byte) length))
                    .putInt(Byte.toUnsignedInt((byte) modeIndex))
                    .putInt((short) mode.getName().length() & 0xFF)
                    .put(mode.getName().getBytes(StandardCharsets.US_ASCII))
                    .putInt(mode.getValue()).putInt(Byte.toUnsignedInt((byte) mode.getFlags()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getSpeedMin()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getSpeedMax()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getBrightnessMin()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getBrightnessMax()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getColorsMin()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getColorsMax()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getSpeed()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getBrightness()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getDirection().ordinal()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getColorType().ordinal()))
                    .putInt((short) mode.getColors().size());

            for (OpenRGBColor color : mode.getColors()) {
                buffer.putInt((byte) color.getRed());
                buffer.putInt((byte) color.getGreen());
                buffer.putInt((byte) color.getBlue());
                buffer.putInt((byte) color.getAlpha());
            }

            sendMessage(OpenRGBPacket.NET_PACKET_ID_RGBCONTROLLER_UPDATEMODE, deviceIndex,
                    buffer.array());
        } finally {
            socketLock.unlock();
        }
    }

    public void saveMode(int deviceIndex, int modeIndex, OpenRGBMode mode) throws IOException {
        socketLock.lock();

        try {
            int length = 60;
            length += mode.getName().length();
            length += 4 * mode.getColors().size();

            ByteBuffer buffer = ByteBuffer.allocate(length).putInt(Byte.toUnsignedInt((byte) length))
                    .putInt(Byte.toUnsignedInt((byte) modeIndex))
                    .putInt((short) mode.getName().length() & 0xFF)
                    .put(mode.getName().getBytes(StandardCharsets.US_ASCII))
                    .putInt(mode.getValue()).putInt(Byte.toUnsignedInt((byte) mode.getFlags()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getSpeedMin()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getSpeedMax()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getBrightnessMin()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getBrightnessMax()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getColorsMin()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getColorsMax()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getSpeed()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getBrightness()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getDirection().ordinal()))
                    .putInt(Byte.toUnsignedInt((byte) mode.getColorType().ordinal()))
                    .putInt((short) mode.getColors().size());

            for (OpenRGBColor color : mode.getColors()) {
                buffer.putInt((byte) color.getRed());
                buffer.putInt((byte) color.getGreen());
                buffer.putInt((byte) color.getBlue());
                buffer.putInt((byte) color.getAlpha());
            }

            sendMessage(OpenRGBPacket.NET_PACKET_ID_RGBCONTROLLER_SAVEMODE, deviceIndex,
                    buffer.array());
        } finally {
            socketLock.unlock();
        }
    }

    private OpenRGBMode readMode(ByteBuffer buffer) {
        OpenRGBMode.Builder builder = new OpenRGBMode.Builder();
        String name = readASCII(buffer);
        builder.setName(name);
        int value = buffer.getInt();
        builder.setValue(value);
        int flags = (buffer.getInt() & 0xff);
        builder.setFlags(flags);
        int speedMin = (buffer.getInt() & 0xff);
        builder.setSpeedMin(speedMin);
        int speedMax = (buffer.getInt() & 0xff);
        builder.setSpeedMax(speedMax);
        int brightnessMin = (buffer.getInt() & 0xff);
        builder.setBrightnessMin(brightnessMin);
        int brightnessMax = (buffer.getInt() & 0xff);
        builder.setBrightnessMax(brightnessMax);
        int colorsMin = (buffer.getInt() & 0xff);
        builder.setColorsMin(colorsMin);
        int colorsMax = (buffer.getInt() & 0xff);
        builder.setColorsMax(colorsMax);
        int speed = (buffer.getInt() & 0xff);
        builder.setSpeed(speed);
        int brightness = (buffer.getInt() & 0xff);
        builder.setBrightness(brightness);
        ModeDirection direction = ModeDirection.parseValue((buffer.getInt() & 0xff));
        builder.setDirection(direction);
        ModeColorType colorType = ModeColorType.parseValue((buffer.getInt() & 0xff));
        builder.setColorType(colorType);
        int numColors = (buffer.getShort() & 0xff);

        for (int i = 0; i < numColors; i++) {
            OpenRGBColor color = readRGBColor(buffer);

            builder.addColor(color);
        }

        return builder.build();
    }

    private OpenRGBZone readZone(ByteBuffer buffer) {
        OpenRGBZone.Builder builder = new OpenRGBZone.Builder();

        String name = readASCII(buffer);
        builder.setName(name);
        ZoneType zoneType = ZoneType.parseValue(buffer.getInt());
        builder.setZoneType(zoneType);
        int ledsMin = (buffer.getInt() & 0xff);
        builder.setLedsMin(ledsMin);
        int ledsMax = (buffer.getInt() & 0xff);
        builder.setLedsMax(ledsMax);
        int ledsCount = (buffer.getInt() & 0xff);
        builder.setLedsCount(ledsCount);
        int matrixLength = readUnsignedShort(buffer);
        builder.setMatrixLength(matrixLength);
        int matrixHeight = Byte.toUnsignedInt(buffer.get());
        builder.setMatrixHeight(matrixHeight);
        int matrixWidth = Byte.toUnsignedInt(buffer.get());
        builder.setMatrixWidth(matrixWidth);

        int[][] matrixData = new int[matrixHeight][matrixWidth];
        for (int i = 0; i < matrixHeight; i++) {
            for (int i1 = 0; i1 < matrixWidth; i1++) {
                matrixData[i][i1] = (buffer.getInt() & 0xff);
            }
        }

        return builder.build();
    }

    private OpenRGBLED readLED(ByteBuffer buffer) {
        OpenRGBLED.Builder builder = new OpenRGBLED.Builder();

        String name = readASCII(buffer);
        builder.setName(name);
        int value = (buffer.getInt() & 0xff);
        builder.setValue(value);

        return builder.build();
    }

    private OpenRGBColor readRGBColor(ByteBuffer buffer) {
        byte r = buffer.get();
        byte g = buffer.get();
        byte b = buffer.get();
        byte a = buffer.get();

        return new OpenRGBColor(Byte.toUnsignedInt(r), Byte.toUnsignedInt(g), Byte.toUnsignedInt(b),
                Byte.toUnsignedInt(a));
    }

    private OpenRGBPlugin readPlugin(ByteBuffer buffer) {
        OpenRGBPlugin.Builder builder = new OpenRGBPlugin.Builder();

        String name = readASCII(buffer);
        builder.setName(name);
        String description = readASCII(buffer);
        builder.setDescription(description);
        String version = readASCII(buffer);
        builder.setVersion(version);
        int index = Byte.toUnsignedInt(buffer.get());
        builder.setIndex(index);
        int protocolVersion = Byte.toUnsignedInt(buffer.get());
        builder.setProtocolVersion(protocolVersion);

        return builder.build();
    }

    private String readASCII(ByteBuffer buffer) {
        int length = (buffer.getShort() & 0xff);
        byte[] charbytes = new byte[length];
        buffer.get(charbytes);

        return new String(charbytes, 0, length, StandardCharsets.US_ASCII);
    }

    private byte[] createHeader(OpenRGBPacket packet, int deviceIndex, byte[] data) {
        return ByteBuffer.allocate(16)
                .order(ByteOrder.LITTLE_ENDIAN)
                .put("ORGB".getBytes())
                .putInt(deviceIndex)
                .putInt(packet.getPacketID())
                .putInt(null != data ? data.length : 0)
                .array();
    }

    private void sendMessage(OpenRGBPacket packet, int deviceIndex, byte[] data) throws IOException {
        byte[] header = createHeader(packet, deviceIndex, data);

        socketLock.lock();

        try {
            out.write(header);

            if (null != data && data.length > 0) {
                out.write(data);
            }
            out.flush();
        } finally {
            socketLock.unlock();
        }
    }

    private ByteBuffer read() throws IOException {
        byte[] header = new byte[16];
        in.read(header, 0, 16);
        ByteBuffer byteBuffer = ByteBuffer.wrap(header).order(ByteOrder.LITTLE_ENDIAN);
        int length = byteBuffer.getInt(12);

        socketLock.lock();
        try {
            byte[] data = readFully(in, length);
            return ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        } finally {
            socketLock.unlock();
        }
    }

    private int readUnsignedShort(ByteBuffer buffer) {
        return buffer.getShort() & 0xff;
    }

    public byte[] readFully(InputStream is, int length) throws IOException {
        byte[] data = new byte[length];
        DataInputStream dis = new DataInputStream(is);
        dis.readFully(data);
        return data;
    }

}
