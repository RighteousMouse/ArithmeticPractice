package com.example.arithmeticpractice

import FastMathMode
import android.R.color.white
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.arithmeticpractice.logic.GameMode
import com.example.arithmeticpractice.logic.Problem
import com.example.arithmeticpractice.logic.ProblemEnums
import com.example.arithmeticpractice.logic.generateProblem
import com.example.arithmeticpractice.ui.screen.GameScreen
import com.example.arithmeticpractice.ui.theme.ArithmeticPracticeTheme
import com.example.arithmeticpractice.ui.theme.PurpleGrey40

// TODO:
//  * Create Operation Button layouts
//  * Create The answer remember game that stores answers
//  * Create a Game Over Screen
//  * Create a Repository that holds user settings
//  * Create a game screen that updates user settings
//  * Create a Title Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ArithmeticPracticeTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {

    // Create the game mode the player will use
    val gameMode = FastMathMode(
        rangeMax = 10,
        operators = setOf(
            ProblemEnums.Operator.ADD,
            ProblemEnums.Operator.SUB,
            ProblemEnums.Operator.MULT,
            ProblemEnums.Operator.DIV
        ),
        answers = setOf(
            ProblemEnums.AnswerType.ANSWER,
            ProblemEnums.AnswerType.NUMBER1,
            ProblemEnums.AnswerType.NUMBER2,
            ProblemEnums.AnswerType.OPERATOR
            )
    )

    Surface(modifier = Modifier.fillMaxSize(),
            color = Color(0xFF4D3B5D)) {
        GameScreen(gameMode, totalTime = 60)
    }
}

class PreviewGameMode : GameMode {
    override val gameName = "Fast Math (Preview)"
    override val rangeMax = 10
    override val validOperators = emptySet<ProblemEnums.Operator>()
    override val validAnswers = emptySet<ProblemEnums.AnswerType>()

    override var currentProblem: Problem = generateProblem(
        10,
        ProblemEnums.Operator.ADD,
        ProblemEnums.AnswerType.ANSWER
    )

    override fun nextProblem() { /* Do nothing for preview */ }

    override fun gameOver(): Boolean = false

    override fun checkAnswer(input: String): Boolean = true
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameScreenPreview() {
    ArithmeticPracticeTheme {
        GameScreen(
            gameMode = PreviewGameMode(),
            totalTime = 60
        )
    }
}