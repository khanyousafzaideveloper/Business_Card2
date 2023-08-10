package com.example.businesscard2

 import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard2.ui.theme.BusinessCard2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCard2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
    Image(painter = painterResource(id = R.drawable.wallpapers_that_are_free_download), contentDescription = null , contentScale = ContentScale.Crop, alpha = 0.2F)
    BusinessCardInfo()
}


}
@Composable
fun BusinessCardInfo(){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        Spacer(modifier = Modifier)
        BrandIdentity(painterResource(R.drawable.logo), "Ahmad Khan", "Android Developer")
        Spacer(modifier = Modifier)
        ContactInfo("030XXXXXXXX", "@KhanYousafzaiDev", "khanyousafzaideveloper@gmail.com")
    }
}

@Composable
fun BrandIdentity(painter: Painter, name: String, title: String) {
    Column(modifier = Modifier.padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painter, contentDescription = "Business logo" , Modifier.size(200.dp) .scale(0.9F, 1.2F))
        Text(text = name, fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}
@Composable
fun ContactInfo(phoneNumber: String, username: String, email: String) {
    Column (modifier = Modifier
        .padding(4.dp)
        .padding(start = 20.dp), horizontalAlignment = Alignment.Start) {
        Row(Modifier.padding(4.dp)) {
            Icon(Icons.Rounded.Call, contentDescription = "Phone icon", Modifier.padding(end = 8.dp))
            Text(text = phoneNumber)
        }
        Row(Modifier.padding(4.dp)) {
            Icon(Icons.Rounded.Share, contentDescription = "share icon", Modifier.padding(end = 8.dp))
            Text(text = username)
        }
        Row (Modifier.padding(4.dp)){
            Icon(Icons.Rounded.Email, contentDescription = "email icon", Modifier.padding(end = 8.dp))
            Text(text = email)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCard2Theme {
        BusinessCard()
    }
}