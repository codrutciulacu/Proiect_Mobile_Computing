package com.university.proiect.mobile.computing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.university.proiect.mobile.computing.ui.screens.SpoonfulApp
import com.university.proiect.mobile.computing.ui.theme.ProiectMobileComputingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProiectMobileComputingTheme {
                SpoonfulApp()
            }
        }
    }
}
