package racingcar.game;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.RaceParticipants;
import racingcar.generator.RandomNumberGenerator;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingGameTest {

    @Test
    void 임계값_이상인_경우에만_전진한다() {
        RaceParticipants participants = RaceParticipants.from(List.of("pobi", "woni"));
        RandomNumberGenerator generator = new FakeNumberGenerator(List.of(4, 3, 4, 9));
        RacingGame racingGame = new RacingGame(participants, generator);

        List<List<String>> roundLogs = racingGame.play(2);
        List<String> winners = racingGame.determineWinners();

        assertThat(roundLogs).hasSize(2);
        assertThat(roundLogs.get(0)).containsExactly("pobi : -", "woni : ");
        assertThat(roundLogs.get(1)).containsExactly("pobi : --", "woni : -");
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void 공동_우승자를_계산한다() {
        RaceParticipants participants = RaceParticipants.from(List.of("pobi", "jun"));
        RandomNumberGenerator generator = new FakeNumberGenerator(List.of(4, 4));
        RacingGame racingGame = new RacingGame(participants, generator);

        racingGame.play(1);
        List<String> winners = racingGame.determineWinners();

        assertThat(winners).containsExactly("pobi", "jun");
    }

    private static class FakeNumberGenerator implements RandomNumberGenerator {

        private final Iterator<Integer> iterator;

        private FakeNumberGenerator(List<Integer> numbers) {
            this.iterator = numbers.iterator();
        }

        @Override
        public int generate() {
            if (!iterator.hasNext()) {
                throw new IllegalStateException("사전 정의된 난수보다 많이 요청했습니다.");
            }
            return iterator.next();
        }
    }
}
