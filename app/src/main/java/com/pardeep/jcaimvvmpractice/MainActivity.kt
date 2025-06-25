package com.pardeep.jcaimvvmpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.pardeep.jcaimvvmpractice.ui.theme.JCAiMvvmPracticeTheme
import com.pardeep.jcaimvvmpractice.view.HomeUi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JCAiMvvmPracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeUi(Modifier.padding(innerPadding))
                }
            }
        }
    }
}