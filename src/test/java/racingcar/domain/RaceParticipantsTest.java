package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RaceParticipantsTest {

    @Test
    void 입력된_이름_수만큼_자동차가_생성된다() {
        RaceParticipants cars = RaceParticipants.from(List.of("pobi", "woni"));

        assertThat(cars.asList()).hasSize(2)
                .extracting(Car::getName)
                .containsExactly("pobi", "woni");
    }

    @Test
    void 컬렉션은_수정할_수_없다() {
        RaceParticipants cars = RaceParticipants.from(List.of("pobi"));

        assertThatThrownBy(() -> cars.asList().add(new Car("woni")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
