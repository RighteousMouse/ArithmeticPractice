package com.example.arithmeticpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.arithmeticpractice.ui.theme.ArithmeticPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArithmeticPracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}

@Composable
fun DisplayProblem() {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArithmeticPracticeTheme {

    }
}