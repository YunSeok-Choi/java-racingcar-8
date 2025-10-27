package racingcar.controller;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.RaceRound;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ResponseControllerTest {

    @Test
    void 라운드_결과를_형식에_맞게_출력한다() {
        ResponseController response = new ResponseController();
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        pobi.moveForward();
        RaceRound firstRound = RaceRound.fromCars(List.of(pobi, woni));

        pobi.moveForward();
        woni.moveForward();
        RaceRound secondRound = RaceRound.fromCars(List.of(pobi, woni));

        List<RaceRound> rounds = List.of(firstRound, secondRound);
        List<String> winners = List.of("pobi");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        try {
            response.printRaceResult(rounds, winners);
        } finally {
            System.setOut(originalOut);
        }

        String lineSeparator = System.lineSeparator();
        String expected = lineSeparator
                + "실행 결과" + lineSeparator
                + "pobi : -" + lineSeparator
                + "woni : " + lineSeparator
                + lineSeparator
                + "pobi : --" + lineSeparator
                + "woni : -" + lineSeparator
                + lineSeparator
                + "최종 우승자 : pobi" + lineSeparator;
        assertThat(outContent.toString()).isEqualTo(expected);
    }
}
