package com.dicoding.jetcharacters.ui.screen.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dicoding.jetcharacters.ui.theme.JetCharactersTheme

@Composable
fun ProfileScreen(
    photo: String,
    email: String,
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        AsyncImage(
            model = photo,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = email,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = name,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewProfileScreen() {
    JetCharactersTheme() {
        ProfileScreen(
            photo = "https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/small/avatar/dos:9f0186765da012b8af63fb5a5dede79a20230608210929.png",
            email = "ayu13pradnyandari@gmail.com",
            name = "Ayu Pradnyandari Dananjaya Erawan",
            modifier = Modifier.fillMaxSize()
        )
    }
}