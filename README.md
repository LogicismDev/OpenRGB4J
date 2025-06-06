# OpenRGB4J - OpenRGB Java Client
[![](https://jitpack.io/v/LogicismDev/OpenRGB4J.svg)](https://jitpack.io/#LogicismDev/OpenRGB4J)

An updated OpenRGB Java Client made to update for the latest OpenRGB Protocol.

## Usage
Gradle
```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.LogicismDev:OpenRGB4J:v1.1'
}
```

Gradle Kotlin DSL
```kotlin
repositories {
    mavenCentral()
    maven { url("https://jitpack.io") }
}

dependencies {
    implementation("com.github.LogicismDev:OpenRGB4J:v1.1")
}
```

Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.github.LogicismDev</groupId>
        <artifactId>OpenRGB4J</artifactId>
        <version>v1.1</version>
    </dependency>
</dependencies>
```

## Examples
To start instantiating the OpenRGB client class, use the following code below as an example.

```java
OpenRGBClient client = new OpenRGBClient("127.0.0.1", 6379, "Your Client Name");

try {
	client.connect();
} catch (IOException e) {
	e.printStackTrace();
}
```

You can grab the device and it's properties by the index as shown by the example below. (e.g. device index is 3)
```java
try {
	OpenRGBDevice device = client.getDeviceController(3);

	String name = device.getName(); // e.g. Razer Kraken V3
	OpenRGBColor color = device.getColors().get(0); // Grab the first color of the device
	String hexCode = color.getHexadecimalCode(); // e.g. #4287f5
} catch (IOException e) {
	e.printStackTrace();
}
```

You can set the LED Color with the example below. (e.g. device index is 3, led index is 2). The OpenRGBColor class is extended from the Java Color class, so you can instantiate the class as you would with the Color class.
```java
try {
	OpenRGBColor color = new OpenRGBColor(66, 135, 245);
	client.updateLED(3, 2, color);
} catch (IOException e) {
	e.printStackTrace();
}
```

## Credits
These repos are the inspirations to what made this library possible.
- https://gitlab.com/CalcProgrammer1/OpenRGB
- https://gitlab.com/mguimard/openrgb-client
