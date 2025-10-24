package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RequestController {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public List<String> readCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        String rawInput = Console.readLine();
        List<String> carNames = splitNames(rawInput);
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public int readAttemptCount() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
        String rawInput = Console.readLine();
        InputValidator.validateAttemptCount(rawInput);
        return Integer.parseInt(rawInput.trim());
    }

    private List<String> splitNames(String rawInput) {
        InputValidator.validateCarNameInput(rawInput);
        return Arrays.stream(rawInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
