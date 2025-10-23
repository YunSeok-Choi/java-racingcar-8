package racingcar;

import racingcar.controller.Controller;
import racingcar.domain.RaceParticipants;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller();

        List<String> carNames = controller.readCarNames();
        int attemptCount = controller.readAttemptCount();

        RaceParticipants cars = RaceParticipants.from(carNames);

        // TODO: Step 3 이후 로직에서 cars와 attemptCount를 활용한다.
    }
}
