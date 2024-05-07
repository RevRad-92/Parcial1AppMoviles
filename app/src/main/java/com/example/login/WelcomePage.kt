package com.example.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.login.ui.theme.LoginTheme

@Composable
fun WelcomePage(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(modifier = modifier) {
        Text(
            text = "Bienvenido!",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "pedro@pe.com.ar",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun WelcomePagePreview() {
    LoginTheme {

        WelcomePage(navController = rememberNavController())
    }
}