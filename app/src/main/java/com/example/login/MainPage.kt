package com.example.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.ui.theme.LoginTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(modifier: Modifier = Modifier) {

    val navController = rememberNavController()




    Text(
        text = "LoginPage",
        modifier = modifier
    )
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "AppParcial")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ){
        NavHost(
            navController = navController,
            modifier = Modifier.padding(it),
            startDestination = "login"
        ){
            composable("login"){
                LoginPage(
                    navController = navController,
                    onNuevoLogin = {user, password ->}
                    )
            }
            composable("welcome"){ WelcomePage(
                navController = navController
            )}
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    LoginTheme {
        MainPage()
    }
}