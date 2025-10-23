package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RaceParticipants {

    private final List<Car> cars;

    private RaceParticipants(List<Car> cars) {
        this.cars = cars;
    }

    public static RaceParticipants from(List<String> carNames) {
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new RaceParticipants(carList);
    }

    public List<Car> asList() {
        return Collections.unmodifiableList(cars);
    }
}
