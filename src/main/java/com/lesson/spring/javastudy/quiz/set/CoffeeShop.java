package com.lesson.spring.javastudy.quiz.set;

import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
//@EqualsAndHashCode
public class CoffeeShop {

    private String name;
    private String location;

    public CoffeeShop(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CoffeeShop that = (CoffeeShop) o;
        return Objects.equals(name, that.name) && Objects.equals(location,
                that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
