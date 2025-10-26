package racingcar.game;

import racingcar.domain.Car;
import racingcar.domain.RaceParticipants;
import racingcar.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int MOVE_THRESHOLD = 4;

    private final RaceParticipants participants;
    private final RandomNumberGenerator numberGenerator;

    public RacingGame(RaceParticipants participants, RandomNumberGenerator numberGenerator) {
        this.participants = participants;
        this.numberGenerator = numberGenerator;
    }

    public List<List<String>> play(int attemptCount) {
        List<List<String>> roundLogs = new ArrayList<>();
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            advanceCars();
            roundLogs.add(captureRoundLog());
        }
        return roundLogs;
    }

    private void advanceCars() {
        for (Car car : participants.getCars()) {
            if (isMovable()) {
                car.moveForward();
            }
        }
    }

    private boolean isMovable() {
        return numberGenerator.generate() >= MOVE_THRESHOLD;
    }

    private List<String> captureRoundLog() {
        List<String> roundLog = new ArrayList<>();
        for (Car car : participants.getCars()) {
            roundLog.add(formatProgress(car));
        }
        return roundLog;
    }

    private String formatProgress(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    public List<String> determineWinners() {
        List<Car> cars = participants.getCars();
        if (cars.isEmpty()) {
            throw new IllegalStateException("참가자 정보가 비어 있습니다.");
        }

        int maxPosition = cars.get(0).getPosition();
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
