package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CarEngine {
    String type;

    //CarEngine(){}

    CarEngine(@Value("Type1") String type){
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CarEngine{" +
                "type='" + type + '\'' +
                '}';
    }
}
