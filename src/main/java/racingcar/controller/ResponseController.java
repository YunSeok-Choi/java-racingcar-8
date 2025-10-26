package racingcar.controller;

import java.util.List;

public class ResponseController {

    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public void printRaceResult(List<List<String>> roundLogs, List<String> winners) {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);

        for (List<String> round : roundLogs) {
            printRound(round);
        }

        printWinners(winners);
    }

    private void printRound(List<String> round) {
        for (String progress : round) {
            System.out.println(progress);
        }
        System.out.println();
    }

    private void printWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE_PREFIX + String.join(WINNER_DELIMITER, winners));
    }
}
