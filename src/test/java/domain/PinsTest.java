package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


import static org.assertj.core.api.Assertions.*;

public class PinsTest {

    @Test
    @DisplayName("Pins 초기에 10개로 셋팅 확인")
    void initPinsTest() {
        int initPins = 10;
        assertThat(Pins.init().getCurrentPins()).isEqualTo(initPins);
    }

    @Test
    @DisplayName("첫번째 투구이후 잔여 Pins 확인")
    void afterFirstbowl() {
        int firstbowl = 3;
        assertThat(Pins.init().knockDown(firstbowl).getCurrentPins()).isEqualTo(7);
    }

    @Test
    @DisplayName("두번째 투구이후 잔여 Pins 확인")
    void afterSecondbowl() {
        int firstbowl = 3;
        int secondbowl = 7;
        assertThat(Pins.init().knockDown(firstbowl).knockDown(secondbowl).getCurrentPins()).isEqualTo(0);
    }

    @DisplayName("범위를 벗어날 경우 Exceptions")
    @ParameterizedTest
    @ValueSource(ints = {11, -1})
    void rangeException(int countOfDownPins) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Pins.init().knockDown(countOfDownPins));
    }

}
