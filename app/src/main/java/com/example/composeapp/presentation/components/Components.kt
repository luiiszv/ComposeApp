package com.example.composeapp.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composeapp.core.network.NetworkStatus

@Composable
fun EstadoConexionBanner(
    estado: NetworkStatus
) {
    AnimatedVisibility(
        visible = estado is NetworkStatus.Unavailable || estado is NetworkStatus.Available,
        enter = fadeIn() + slideInVertically(),
        exit = fadeOut() + slideOutVertically()
    ) {
        val color = if (estado is NetworkStatus.Available) Color(0xFF4CAF50) else Color(0xFFF44336)
        val mensaje = if (estado is NetworkStatus.Available) "Conectado — trabajando online"
        else "Sin conexión — trabajando offline"

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color)
                .padding(8.dp)
        ) {
            Text(
                text = mensaje,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
