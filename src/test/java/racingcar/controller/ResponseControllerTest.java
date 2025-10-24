package racingcar.controller;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ResponseControllerTest {

    @Test
    void 라운드_결과를_형식에_맞게_출력한다() {
        ResponseController response = new ResponseController();
        List<List<String>> roundStates = List.of(
                List.of("pobi : -", "woni : "),
                List.of("pobi : --", "woni : -")
        );

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        try {
            response.printRaceProgress(roundStates);
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
                + lineSeparator;
        assertThat(outContent.toString()).isEqualTo(expected);
    }
}
