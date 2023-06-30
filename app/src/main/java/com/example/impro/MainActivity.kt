package com.example.impro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.impro.ui.theme.ImProTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImProTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BackgroundWithButton(onButtonClick = {})
                }
            }
        }
    }
}

@Composable
fun BackgroundWithButton(onButtonClick: () -> Unit) {
    var showQRCode by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = stringResource(R.string.background_image),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            ImageButton(
                onClick = {
                    showQRCode = !showQRCode
                    onButtonClick()
                }
            )
        }
        if (showQRCode) {
            QRCodeImage(
                showImage = true
            )
        }
    }
}

@Composable
fun ImageButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(R.drawable.button),
        contentDescription = stringResource(R.string.image_button),
        modifier = Modifier
            .padding
                (top = 32.dp, start = 16.dp, end = 16.dp)
            .clickable(onClick = onClick)
            .size(240.dp)
    )
}

@Composable
fun QRCodeImage(
    modifier: Modifier = Modifier,
    showImage: Boolean
) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.qrcode),
            contentDescription = stringResource(R.string.qr_image_desc),
            modifier = Modifier
                .padding(32.dp)
                .size(350.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview() {
    ImProTheme {
        BackgroundWithButton(onButtonClick = {})
    }
}