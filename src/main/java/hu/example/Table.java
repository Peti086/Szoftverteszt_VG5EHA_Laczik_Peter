package hu.example;

public class Table {
    private int width, length, height, currentHeight;
    private boolean isAdjustable;
    private String color;
    private int numberOfLegs;

    // 1. Eredeti konstruktor (nem állítható)
    public Table(int width, int length, int height) {
        this(width, length, height, height, false, "alap", 4);
    }

    // 2. Eredeti konstruktor (állítható)
    public Table(int width, int length, int height, int currentHeight) {
        this(width, length, height, currentHeight, true, "alap", 4);
    }

    // Új bővített konstruktor az új attribútumokhoz
    public Table(int width, int length, int height, int currentHeight, boolean isAdjustable, String color, int numberOfLegs) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.currentHeight = currentHeight;
        this.isAdjustable = isAdjustable;
        this.color = color;
        this.numberOfLegs = numberOfLegs;
    }

    public void setHeight(int newHeight) {
        if (!isAdjustable) {
            throw new IllegalStateException("Nem állítható.");
        }
        if (newHeight < 0 || newHeight > 200) {
            throw new IllegalArgumentException("0-200 között kell lennie.");
        }
        this.currentHeight = newHeight;
    }

    public int area() {
        return width * length;
    }

    public int getCapacity() {
        return getPerimeter() / 60;
    }

    public void repaint(String newColor) {
        this.color = newColor;
    }

    public boolean isStable() {
        return numberOfLegs >= 3;
    }

    public boolean isFoldable() {
        return isAdjustable && numberOfLegs >= 4;
    }

    public int getPerimeter() {
        return 2 * (width + length);
    }

    public int getWidth() { return width; }
    public int getLength() { return length; }
    public int getHeight() { return height; }
    public int getCurrentHeight() { return currentHeight; }
    public boolean isAdjustable() { return isAdjustable; }
    public String getColor() { return color; }
    public int getNumberOfLegs() { return numberOfLegs; }
}
