package com.example.barcode

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.barcode.ui.theme.BarCodeTheme
import com.simonsickle.compose.barcodes.Barcode
import com.simonsickle.compose.barcodes.BarcodeType

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BarCodeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                   NavHost()
                }
            }
        }
    }
}

@Composable
fun BarCodeGenerate(uuidUser: String, navHostController: NavHostController) {
    if (BarcodeType.CODE_128.isValueValid(uuidUser)) {
        Column(Modifier.fillMaxSize()
            .clickable {
                navHostController.navigate("Barcode")
            },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Barcode(
                modifier = Modifier
                    .width(300.dp)
                    .height(300.dp),
                resolutionFactor = 1,
                type = BarcodeType.CODE_128,
                value = uuidUser
            )
        }
    }
}