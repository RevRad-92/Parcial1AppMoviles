package com.example.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.login.ui.theme.LoginTheme
import java.io.DataInput

@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    navController: NavController,
    onNuevoLogin: (user: String, password: String) -> Unit
) {
    var user by remember { mutableStateOf("Usuario") }
    var password by remember { mutableStateOf("Contraseña") }

    var mensaje by remember { mutableStateOf<Boolean>(false)}

    Column(modifier.padding(horizontal = 30.dp)){
        Text(
            text = "Iniciá sesión"
        )
        Text(
            text = "Ingresá tu usuario (email)",
            modifier = Modifier.padding(top = 20.dp)
        )
        TextField(
            value = user,
            onValueChange = {
                user = it
            },
            modifier = modifier
                .padding(top = 10.dp)
                .fillMaxWidth(1f))


        Text(
            text = "Ingresá tu contraseña",
            modifier = Modifier.padding(top = 20.dp)
        )
        TextField(
            value = password,
            onValueChange = { password = it},
            modifier = modifier
                .padding(top = 10.dp)
                .fillMaxWidth(1f))


        Button(
            onClick = {
                if (user == "pedro@pe.com.ar" && password == "abc123" ) {
                    mensaje = false
                    navController.navigate("welcome")
                    onNuevoLogin(user, password)
                } else {
                    mensaje = true
                }

            }, modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp)
        ) {
            Text(
                text = "Login",
                modifier = modifier.padding(horizontal = 20.dp)
            )
        }

        if (mensaje) {
            Text(
                text = "Usuario y/o Contraseña incorrecta",
                modifier = Modifier.align(Alignment.CenterHorizontally)

            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginTheme {
        LoginPage(navController = rememberNavController(), onNuevoLogin = {user, password ->})
    }
}