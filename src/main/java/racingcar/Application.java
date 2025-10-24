package racingcar;

import racingcar.controller.RequestController;
import racingcar.domain.RaceParticipants;
import racingcar.game.RacingGame;
import racingcar.generator.MissionRandomNumberGenerator;
import racingcar.generator.RandomNumberGenerator;
import racingcar.controller.ResponseController;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        RequestController request = new RequestController();

        List<String> carNames = request.readCarNames();
        int attemptCount = request.readAttemptCount();

        RaceParticipants raceParticipants = RaceParticipants.from(carNames);

        RandomNumberGenerator numberGenerator = new MissionRandomNumberGenerator();
        RacingGame racingGame = new RacingGame(raceParticipants, numberGenerator);

        List<List<String>> roundStates = racingGame.play(attemptCount);

        ResponseController response = new ResponseController();
        response.printRaceProgress(roundStates);

        // TODO: Step 4 이후 로직에서 우승자 계산과 최종 출력 처리를 추가한다.
    }
}
