package com.example.cardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cardapp.ui.theme.CardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Intro(name = stringResource(R.string.name),
                        position = stringResource(id = R.string.position)
                    )
                    Contact()
                }
            }
        }
    }
}

@Composable
fun Intro(name: String,position:String ,modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            Modifier
                .padding(16.dp)
                .width(150.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = name,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(12.dp)
        )
        Text(
            text = position,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(bottom = 10.dp)
        )
    }
}

@Composable
fun ContactInfo(painter: Painter,url: String){
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painter, contentDescription = "logo",
            modifier = Modifier
                .width(48.dp)
                .height(48.dp)
                .padding(7.dp, top = 15.dp)
        )
        Text(
            text = url,
            modifier = Modifier.padding(top = 15.dp)
        )
    }

}

@Composable
fun Contact() {
    Column (
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(15.dp, bottom = 70.dp)
    ){
        ContactInfo(
            painter = painterResource(id = R.drawable.mail_logo),
            url = stringResource(id = R.string.mail)
        )
        ContactInfo(
            painter = painterResource(id = R.drawable.github),
            url = stringResource(id = R.string.git_hub)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CardAppTheme {
        Intro(name = stringResource(R.string.name),
            position = stringResource(id = R.string.position)
        )
        Contact()
    }
}