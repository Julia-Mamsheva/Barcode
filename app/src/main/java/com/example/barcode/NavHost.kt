package com.example.barcode

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost

@Composable
fun NavHost() {
    val navHost = rememberNavController()

    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            NavHost(navHost, "Main") {
                composable("Barcode") {
                    Barcode("87f73dd6-0781-4818-b195-cfa4d7a55dcf")
                }
                composable("Main")
                {
                    BarCodeGenerate("87f73dd6-0781-4818-b195-cfa4d7a55dcf",navHost)
                }
            }
        }
    }
}