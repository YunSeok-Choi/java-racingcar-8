package racingcar.validation;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputValidatorTest {

    @Test
    void 빈_자동차_이름_문자열이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateCarNameInput("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어 있을 수 없습니다");
    }

    @Test
    void 자동차_이름이_비어있으면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(List.of("pobi", "")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어 있을 수 없습니다");
    }

    @Test
    void 자동차_이름이_5자를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(List.of("pobi22")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1자 이상 5자 이하");
    }

    @Test
    void 자동차_이름이_영문과_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(List.of("po-bi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("영문과 숫자로만");
    }

    @Test
    void 정상적인_자동차_이름이면_예외가_발생하지_않는다() {
        assertThatCode(() -> InputValidator.validateCarNames(List.of("pobi", "woni1")))
                .doesNotThrowAnyException();
    }

    @Test
    void 시도_횟수가_음수거나_0이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateAttemptCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양의 정수");
    }

    @Test
    void 시도_횟수가_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateAttemptCount("three"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양의 정수");
    }

    @Test
    void 정상적인_시도_횟수면_예외가_발생하지_않는다() {
        assertThatCode(() -> InputValidator.validateAttemptCount("5"))
                .doesNotThrowAnyException();
    }
}
