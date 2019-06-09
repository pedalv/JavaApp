package no.agitec.fagaften.mars.kotlin.section09.calljava1.javacode;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Car {

    private String color;
    private String model;
    private String modelA;
    private String modelA2;
    private int year;

    public Car(String color, String model, int year) {
        this.color = color;
        this.model = model;
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(@NotNull String color) {
        this.color = color;
    }

    public  String getModel() {
        return model;
    }

    public @Nullable
    String getModelA() {
        return modelA;
    }

    public @NotNull String getModelA2() {
        return modelA2;
    }

    public void setModel(/*@NotNull*/ String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
