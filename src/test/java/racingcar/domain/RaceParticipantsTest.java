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
        RaceParticipants participants = RaceParticipants.from(List.of("pobi", "woni"));

        assertThat(participants.getCars()).hasSize(2)
                .extracting(Car::getName)
                .containsExactly("pobi", "woni");
    }

}
