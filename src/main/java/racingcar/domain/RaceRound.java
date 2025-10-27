package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceRound {

    private final List<String> progressLogs;

    public RaceRound(List<String> progressLogs) {
        this.progressLogs = progressLogs;
    }

    public List<String> toProgressLogs() {
        return progressLogs;
    }

    public List<String> getProgressLogs() {
        return progressLogs;
    }

    public static RaceRound fromCars(List<Car> cars) {
        List<String> logs = new ArrayList<>();
        for (Car car : cars) {
            logs.add(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        return new RaceRound(logs);
    }
}
