package racing

fun inputCarCount(): Int {
    println("자동차 대수는 몇 대인가요?")
    return getInputValue()
}

fun inputTryCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return getInputValue()
}

fun getInputValue(): Int {
    val value = readLine()
    require(value != null) { "입력값이 빈 값이면 안됩니다." }

    try {
        val intValue = value.toInt()

        require(intValue > 0) { "입력값은 0보다 큰 자연수이어야 합니다." }

        return intValue
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("자연수를 입력해주세요.")
    }
}