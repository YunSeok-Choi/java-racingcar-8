package racingcar;

import racingcar.controller.RequestController;
import racingcar.controller.ResponseController;
import racingcar.domain.RaceParticipants;
import racingcar.game.RacingGame;
import racingcar.generator.MissionRandomNumberGenerator;
import racingcar.generator.RandomNumberGenerator;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        RequestController request = new RequestController();
        ResponseController response = new ResponseController();
        RandomNumberGenerator numberGenerator = new MissionRandomNumberGenerator();

        List<String> carNames = request.readCarNames();
        int attemptCount = request.readAttemptCount();

        RaceParticipants raceParticipants = RaceParticipants.from(carNames);

        RacingGame racingGame = new RacingGame(raceParticipants, numberGenerator);
        List<List<String>> roundLogs = racingGame.play(attemptCount);
        List<String> winners = racingGame.determineWinners();

        response.printRaceResult(roundLogs, winners);
    }
}
