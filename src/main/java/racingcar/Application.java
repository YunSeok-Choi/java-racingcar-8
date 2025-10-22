package racingcar;

import racingcar.controller.Controller;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller();

        List<String> carNames = controller.readCarNames();
        int attemptCount = controller.readAttemptCount();

        // TODO: Step 2 이후 로직에서 carNames와 attemptCount를 활용한다.
    }
}
