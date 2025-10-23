package racingcar.domain;

import racingcar.validation.InputValidator;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        InputValidator.validateCarName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position++;
    }
}
