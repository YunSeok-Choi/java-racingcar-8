package racingcar.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    @Test
    void 이름이_유효하지_않으면_생성에_실패한다() {
        assertThatThrownBy(() -> new Car("po-bi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성_직후_위치는_0이다() {
        Car car = new Car("pobi");

        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 이동하면_위치가_1_증가한다() {
        Car car = new Car("pobi");

        car.moveForward();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
