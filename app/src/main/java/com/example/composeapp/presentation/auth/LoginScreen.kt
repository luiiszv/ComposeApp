package com.example.composeapp.presentation.auth

import android.service.autofill.OnClickAction
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.composeapp.R


@Composable
fun LoginScreen(
    navHostController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()

) {

    val email = viewModel.email
    val password = viewModel.password


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {


        ImageLogo(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        InputEmail(
            modifier = Modifier.fillMaxWidth(),
            email = email,
            isValid = viewModel.isEmailValido,
            onEmailChanged = viewModel::onEmailChanged,
        )
        InputPassword(
            modifier = Modifier.fillMaxWidth(),
            password = password,
            isValid = viewModel.isPasswordValid,
            onPasswordChanged = viewModel::onPasswordChenged,
        )

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        ButtonLogin(
            onClick = { viewModel.onLoginClick() },
            isEnabled = viewModel.isEmailValido && viewModel.isPasswordValid,
            modifier = Modifier
                .fillMaxWidth()
        )


    }

}


@Composable
fun InputEmail(
    modifier: Modifier = Modifier,
    email: String,
    isValid: Boolean,
    onEmailChanged: (String) -> Unit
) {

    OutlinedTextField(
        value = email,
        onValueChange = onEmailChanged,
        label = { Text("Correo electrónico") },
        placeholder = { Text("ejemplo@correo.com") },
        leadingIcon = {
            Icon(Icons.Default.Email, contentDescription = null)
        },
        isError = email.isNotBlank() && !isValid,
        singleLine = true,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp)
    )

}


@Composable
fun InputPassword(
    modifier: Modifier,
    password: String,
    isValid: Boolean,
    onPasswordChanged: (String) -> Unit
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChanged,
        label = { Text("Contraseña") },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        placeholder = { Text("******") },
        leadingIcon = {
            Icon(Icons.Default.Lock, contentDescription = null)
        },
        isError = password.isNotBlank() && !isValid,
        singleLine = true,
        modifier = modifier,
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else
                Icons.Default.VisibilityOff

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, contentDescription = null)
            }
        },
        shape = RoundedCornerShape(16.dp)
    )

}


@Composable
fun ButtonLogin(
    onClick: () -> Unit,
    isEnabled: Boolean,
    modifier: Modifier


) {

    Button(
        onClick = onClick,
        enabled = isEnabled,
        shape = shape,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.primary)
        )

    ) {
        Text("Iniciar Sesión")
    }


}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_gemini),
        contentDescription = "logo",
        modifier = modifier
    )
}

