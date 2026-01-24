package com.example.arithmeticpractice

//Types of games:
//Fast problems - single problem user writes the answer
//Choose the operator - user enters the correct operator
//Memory Problems - user keeps the answer in their mind while adding or subtracting
//multiplying or dividing the answer and writing the result. On a wrong answer

fun generateProblem(rangeMax: Int):Problem {
    require(rangeMax >= 1)

    val numb1 = (1..rangeMax).random()
    val numb2 = (1..rangeMax).random()
    var op = randomOperator()
    while (!validNumbs(numb1,numb2,op))
        op = randomOperator()
    val answer = executeProblem(numb1,numb2,op)
    return Problem(numb1,numb2,op,answer)
}
data class Problem(
    val numb1: Int,
    val numb2: Int,
    val operator: Operator,
    val answer: Int
)
fun randomOperator(): Operator = Operator.entries.random()
enum class Operator(val symbol: String) {
    ADD("+"),
    SUB("-"),
    MULT("×"),
    DIV("÷")
}

fun add(numb1: Int, numb2: Int): Int = numb1 + numb2

fun subtract(numb1: Int, numb2: Int): Int = numb1 - numb2

fun multiply(numb1: Int, numb2: Int): Int = numb1 * numb2

fun divide(numb1: Int, numb2: Int): Int = numb1 / numb2

fun executeProblem(numb1: Int, numb2: Int, operator: Operator): Int{
    return when (operator) {
        Operator.ADD -> add(numb1, numb2)
        Operator.SUB -> subtract(numb1, numb2)
        Operator.MULT -> multiply(numb1, numb2)
        Operator.DIV -> divide(numb1, numb2)
    }
}
fun validNumbs(numb1: Int, numb2: Int, operator: Operator): Boolean {
    return when (operator) {
        Operator.ADD -> true
        Operator.SUB -> numb1 - numb2 >= 0
        Operator.MULT -> true
        Operator.DIV -> numb2 != 0 && numb1 % numb2 == 0
    }
}