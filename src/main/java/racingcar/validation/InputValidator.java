package racingcar.validation;

import java.util.List;

public final class InputValidator {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_PATTERN = "^[a-zA-Z0-9]+$";

    private InputValidator() {
    }

    public static void validateCarNameInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("자동차 이름 목록은 필수 입력입니다.");
        }

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 목록은 비어 있을 수 없습니다.");
        }
    }

    public static void validateCarNames(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("최소 한 대 이상의 자동차 이름이 필요합니다.");
        }

        for (String name : names) {
            validateSingleName(name);
        }
    }

    private static void validateSingleName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }

        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }

        if (!name.matches(NAME_PATTERN)) {
            throw new IllegalArgumentException("자동차 이름은 영문과 숫자로만 구성되어야 합니다.");
        }
    }

    public static void validateAttemptCount(String input) {
        if (input == null) {
            throw new IllegalArgumentException("시도 횟수는 필수 입력입니다.");
        }

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수는 비어 있을 수 없습니다.");
        }

        if (!isPositiveInteger(input.trim())) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }
    }

    private static boolean isPositiveInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            return value > 0;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
