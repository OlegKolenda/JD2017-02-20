package by.it.prigozhanov.jd03_03.beans;

/**
 * Created by v-omf on 4/29/2017!
 */
public class Car {

    private int id;
    private String mark;
    private String model;
    private int hp;
    private String location;
    private int luggageCapacity;

    public Car(int id, String mark, String model, int hp, String location, int luggageCapacity) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.hp = hp;
        this.location = location;
        this.luggageCapacity = luggageCapacity;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLuggageCapacity() {
        return luggageCapacity;
    }

    public void setLuggageCapacity(int luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (hp != car.hp) return false;
        if (luggageCapacity != car.luggageCapacity) return false;
        if (mark != null ? !mark.equals(car.mark) : car.mark != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        return location != null ? location.equals(car.location) : car.location == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + hp;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + luggageCapacity;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", hp=" + hp +
                ", location='" + location + '\'' +
                ", luggageCapacity=" + luggageCapacity +
                '}';
    }
}
