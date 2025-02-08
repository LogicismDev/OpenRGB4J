package me.Logicism.OpenRGB4J.openrgb.entities;

import java.awt.*;
import java.awt.color.ColorSpace;

public class OpenRGBColor extends Color {
    public OpenRGBColor(int r, int g, int b) {
        super(r, g, b);
    }

    public OpenRGBColor(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    public OpenRGBColor(int rgb) {
        super(rgb);
    }

    public OpenRGBColor(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }

    public OpenRGBColor(float r, float g, float b) {
        super(r, g, b);
    }

    public OpenRGBColor(float r, float g, float b, float a) {
        super(r, g, b, a);
    }

    public OpenRGBColor(ColorSpace cspace, float[] components, float alpha) {
        super(cspace, components, alpha);
    }

    public String getHexadecimalCode() {
        String hexColor = String.format("#%02x%02x%02x", this.getRed(), this.getGreen(), this.getBlue());

        if (this.getAlpha() < 1) {
            int alphaInt = (int) Math.round(this.getAlpha() * 255);
            hexColor += String.format("%02x", alphaInt);
        }

        return hexColor;
    }
}
