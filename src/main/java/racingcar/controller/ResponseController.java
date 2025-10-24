package racingcar.controller;

import java.util.List;

public class ResponseController {

    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public void printRaceProgress(List<List<String>> roundLogs) {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);

        for (List<String> round : roundLogs) {
            printRound(round);
        }
    }

    private void printRound(List<String> round) {
        for (String progress : round) {
            System.out.println(progress);
        }
        System.out.println();
    }
}
