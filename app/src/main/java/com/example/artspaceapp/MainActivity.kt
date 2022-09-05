package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = LightGray
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentImageAndText by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier.padding(
            32.dp
        ),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        when (currentImageAndText) {
            1 -> {
                ArtSpaceImageAndText(
                    imageResourceId = R.drawable.image1,
                    titleResourceId = R.string.title_image1,
                    artistResourceId = R.string.artist_image1,
                    yearResourceId = R.string.year_image1
                )
            }
            2 -> {
                ArtSpaceImageAndText(
                    imageResourceId = R.drawable.image2,
                    titleResourceId = R.string.title_image2,
                    artistResourceId = R.string.artist_image2,
                    yearResourceId = R.string.year_image2
                )
            }
            3 -> {
                ArtSpaceImageAndText(
                    imageResourceId = R.drawable.image3,
                    titleResourceId = R.string.title_image3,
                    artistResourceId = R.string.artist_image3,
                    yearResourceId = R.string.year_image3
                )
            }
            4 -> {
                ArtSpaceImageAndText(
                    imageResourceId = R.drawable.image4,
                    titleResourceId = R.string.title_image4,
                    artistResourceId = R.string.artist_image4,
                    yearResourceId = R.string.year_image4
                )
            }
            5 -> {
                ArtSpaceImageAndText(
                    imageResourceId = R.drawable.image5,
                    titleResourceId = R.string.title_image5,
                    artistResourceId = R.string.artist_image5,
                    yearResourceId = R.string.year_image5
                )
            }
            6 -> {
                ArtSpaceImageAndText(
                    imageResourceId = R.drawable.image6,
                    titleResourceId = R.string.title_image6,
                    artistResourceId = R.string.artist_image6,
                    yearResourceId = R.string.year_image6
                )
            }
        }
        ButtonsPreviousAndNext(
            modifierButton = Modifier
                .height(35.dp)
                .width(130.dp),
            { if (currentImageAndText == 1) currentImageAndText = 6 else currentImageAndText-- },
            { if (currentImageAndText == 6) currentImageAndText = 1 else currentImageAndText++ }
        )
    }
}

@Composable
fun ArtSpaceImageAndText(
    imageResourceId: Int,
    titleResourceId: Int,
    artistResourceId: Int,
    yearResourceId: Int,
) {
    Column {
        Image(
            painter = painterResource(imageResourceId),
            contentDescription = stringResource(titleResourceId),
            modifier = Modifier
                .border(border = BorderStroke(width = 3.dp, color = Black))
                .padding(
                    16.dp
                )
        )
    }

    Surface(
        modifier = Modifier
            .heightIn(80.dp, 300.dp)
            .widthIn(300.dp, 380.dp),
        shape = RectangleShape,
        elevation = 12.dp,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = stringResource(titleResourceId),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                Text(text = stringResource(artistResourceId, ")"), fontSize = 18.sp)
                Text(
                    text = stringResource(yearResourceId),
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic
                )

            }
        }
    }
}

@Composable
fun ButtonsPreviousAndNext(
    modifierButton: Modifier,
    onClickPrev: () -> Unit,
    onClickNext: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = onClickPrev, modifier = modifierButton) {
                Text(text = "Previous")
            }
            Button(onClick = onClickNext, modifier = modifierButton) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}