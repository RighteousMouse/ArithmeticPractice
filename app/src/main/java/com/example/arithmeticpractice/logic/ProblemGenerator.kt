package com.example.arithmeticpractice.logic
import android.R.attr.data
import com.example.arithmeticpractice.logic.ProblemEnums.AnswerType
import com.example.arithmeticpractice.logic.ProblemEnums.Operator
fun generateProblem(
    rangeMax: Int,
    operator: ProblemEnums.Operator,
    blank: ProblemEnums.AnswerType
): Problem {

    return when (operator) {
        ProblemEnums.Operator.ADD -> generateAddition(rangeMax, blank)
        ProblemEnums.Operator.SUB -> generateSubtraction(rangeMax, blank)
        ProblemEnums.Operator.MULT -> generateMultiplication(rangeMax, blank)
        ProblemEnums.Operator.DIV -> generateDivision(rangeMax, blank)
    }
}
fun generateDivision(rangeMax: Int, blank: AnswerType): Problem {
    require(rangeMax >= 1)

    val numb1 = (rangeMax/2..rangeMax).random()
    var numb2 = (1..rangeMax/2).random()
    val op = Operator.DIV

    while(!validNumbs(numb1,numb2,op))
        numb2 = (1..rangeMax/2).random()

    val answer = executeProblem(numb1,numb2,op)

    return Problem(numb1,op,numb2,answer,blank)
}
fun generateMultiplication(rangeMax: Int, blank: AnswerType): Problem {
    require(rangeMax >= 1)

    val numb1 = (1..rangeMax).random()
    val numb2 = (1..rangeMax).random()
    val op = Operator.MULT
    val answer = executeProblem(numb1,numb2,op)

    return Problem(numb1,op,numb2,answer,blank)
}
fun generateAddition(rangeMax: Int, blank: AnswerType): Problem {
    require(rangeMax >= 1)

    val numb1 = (1..rangeMax).random()
    val numb2 = (1..rangeMax).random()
    val op = Operator.ADD
    val answer = executeProblem(numb1,numb2,op)

    return Problem(numb1,op,numb2,answer,blank)
}
fun generateSubtraction(rangeMax: Int, blank: AnswerType): Problem {
    require(rangeMax >= 1)

    val numb1 = (rangeMax/2..rangeMax).random()
    val numb2 = (1..numb1).random()
    val op = Operator.SUB
    val answer = executeProblem(numb1,numb2,op)

    return Problem(numb1,op,numb2,answer,blank)
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
data class Problem(
    val numb1: Int,
    var operator: Operator,
    val numb2: Int,
    val answer: Int,
    var blankPart: AnswerType
)