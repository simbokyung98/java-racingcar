package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingProcessTest {

    private  String[] nameArray = {"rubal", "pubao", "ibao"};
    private RacingProcess racingProcess;
    MovingStrategy movingStrategy;

    @BeforeEach
    void create() {
        movingStrategy = new GreaterThanThreeMovingStrategy();
        racingProcess = new RacingProcess(nameArray, movingStrategy);
    }

    @Test
    @DisplayName("경주방식 객체 생성이 되었는지 확인")
    void 경주방식_객체_확인() {
        assertThat(racingProcess).isNotNull();
    }


    @Test
    @DisplayName("경주시작 시 자동차 객체를 입력한 자동차 대수만큼 생성시키는지 확인")
    void 자동차준비_확인() {

        assertThat(racingProcess.getCarsStatus()).hasSize(nameArray.length);
    }

    @Test
    @DisplayName("자동차 경주를 실행시켜 모든 자동차를 전진하게 할 때 결과 확인")
    void 자동차경주_라운드_진행_결과() {
        NumberGenerator movableRandomGenerator = new MovableRandomGenerator();
        racingProcess.roundPlay(movableRandomGenerator);
        assertThat(racingProcess.getCarsStatus())
                .containsOnly(entry(nameArray[0],1),entry(nameArray[1],1),entry(nameArray[2],1));
    }
}
