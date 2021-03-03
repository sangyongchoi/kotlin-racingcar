package racingcar_winner

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar_winner.model.Car
import racingcar_winner.model.CarManager
import racingcar_winner.model.Cars
import java.util.stream.Stream

class CarManagerTest {

    private val carManager = CarManager()

    @ParameterizedTest
    @MethodSource("orderCarParameters")
    fun `이름들을 전달 받았을 때 차들을 생성한다`(carNames: List<String>, expected: Cars) {
        assertThat(carManager.orderMakingCars(carNames).toString()).isEqualTo(expected.toString())
    }

    @Test
    fun `이름중에 5글자 이상인 글자가 존재할 때`() {
        val list = listOf("Johnson", "dfdf", "dffff")
        assertThatThrownBy { carManager.orderMakingCars(list) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    companion object {
        @JvmStatic
        fun orderCarParameters(): Stream<Arguments> {
            return Stream.of(
                arguments(
                    listOf("Kim", "Jeong", "eun"), Cars(
                        listOf(
                            Car("Kim"),
                            Car("Jeong"),
                            Car("eun")
                        )
                    )
                )
            )
        }
    }
}