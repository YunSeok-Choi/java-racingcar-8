package racingcar.game;

import racingcar.domain.Car;
import racingcar.domain.RaceParticipants;
import racingcar.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return List.copyOf(roundLogs);
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
        return participants.getCars().stream()
                .map(this::formatProgress)
                .toList();
    }

    private String formatProgress(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }
}
