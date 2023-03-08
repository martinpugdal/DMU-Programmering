import javafx.scene.paint.Color;

public class Car {

    private Color color;
    private int doors;
    private int windows;
    private int wheels;

    public Car() {
        color = Color.RED;
        doors = 1;
        windows = 4;
        wheels = 3;
    }

    public Car(int doors, int windows) {
        this();
        this.doors = doors;
        this.windows = windows;
    }

    public Car(int doors, int windows, int wheels) {
        this();
        this.doors = doors;
        this.windows = windows;
        this.wheels = wheels;
    }

    public Car(Color color, int doors, int windows) {
        this();
        this.color = color;
        this.doors = doors;
        this.windows = windows;
    }

    public Color getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    public int getWheels() {
        return wheels;
    }

    public int getWindows() {
        return windows;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    @Override
    public String toString() {
        return color + " Vehicle with " + doors + " doors";
    }

}
