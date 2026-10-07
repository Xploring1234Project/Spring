package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
    String name;
    String model;
    //@Autowired  // field injection
    CarEngine engine;

    //Car(){}


    //Constructor Injection
    Car(@Value("BMW") String name,@Value("Model1") String model, CarEngine engine){
        this.name = name;
        this.model = model;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


   public CarEngine getEngine() {
        return engine;
    }

    //@Autowired  // Setter Injection
    public void setEngine(CarEngine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                '}';
    }
}
