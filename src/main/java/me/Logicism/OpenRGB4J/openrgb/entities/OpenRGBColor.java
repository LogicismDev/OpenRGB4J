package me.Logicism.OpenRGB4J.openrgb.entities;

import java.awt.*;
import java.awt.color.ColorSpace;

/**
 * The OpenRGBColor entity class extended from the Java Color class
 */
public class OpenRGBColor extends Color {
    /**
     * Instantiates the OpenRGBColor class with the RGB integers
     *
     * @param r The Red Integer
     * @param g The Green Integer
     * @param b The Blue Integer
     */
    public OpenRGBColor(int r, int g, int b) {
        super(r, g, b);
    }

    /**
     * Instantiates the OpenRGBColor class with the RGBA integers
     *
     * @param r The Red Integer
     * @param g The Green Integer
     * @param b The Blue Integer
     * @param a The Alpha Integer
     */
    public OpenRGBColor(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    /**
     * Instantiates the OpenRGBColor class with the RGB integer
     *
     * @param rgb The Red, Green, and Blue Integer
     */
    public OpenRGBColor(int rgb) {
        super(rgb);
    }


    /**
     * Instantiates the OpenRGBColor class with the RGBA integer
     *
     * @param rgba The Red, Green, Blue, and Alpha Integer
     * @param hasalpha If the RGBA Integer has Alpha
     */
    public OpenRGBColor(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }

    /**
     * Instantiates the OpenRGBColor class with the RGB Floats
     *
     * @param r The Red Float
     * @param g The Green Float
     * @param b The Blue Float
     */
    public OpenRGBColor(float r, float g, float b) {
        super(r, g, b);
    }

    /**
     * Instantiates the OpenRGBColor class with the RGBA Floats
     *
     * @param r The Red Float
     * @param g The Green Float
     * @param b The Blue Float
     * @param a The Alpha Float
     */
    public OpenRGBColor(float r, float g, float b, float a) {
        super(r, g, b, a);
    }

    /**
     * Instantiates the OpenRGBColor class with the Color Space, Components and Alpha
     *
     * @param cspace The ColorSpace
     * @param components The components in a float array
     * @param alpha The Alpha Float
     */
    public OpenRGBColor(ColorSpace cspace, float[] components, float alpha) {
        super(cspace, components, alpha);
    }

    /**
     * Converts the Color into a Hexadecimal Code
     *
     * @return The Hexadecimal Code converted
     */
    public String getHexadecimalCode() {
        String hexColor = String.format("#%02x%02x%02x", this.getRed(), this.getGreen(), this.getBlue());

        if (this.getAlpha() < 1) {
            int alphaInt = (int) Math.round(this.getAlpha() * 255);
            hexColor += String.format("%02x", alphaInt);
        }

        return hexColor;
    }
}
