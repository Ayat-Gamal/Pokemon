package com.example.pokemon.util.uiStates


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Error view with retry option
 * Shows different icons based on error type
 */
@Composable
fun ErrorView(
    message: String,
    modifier: Modifier = Modifier,
    isRetry: Boolean = true,
    onRetry: () -> Unit = {}
) {
    // Determine icon based on error message
    val icon = when {
        message.contains("network", ignoreCase = true) ||
                message.contains("internet", ignoreCase = true) -> Icons.Default.Info

        message.contains("server", ignoreCase = true) ||
                message.contains("timeout", ignoreCase = true) -> Icons.Default.Close

        else -> Icons.Default.Email
    }

    val title = when {
        message.contains("network", ignoreCase = true) ||
                message.contains("internet", ignoreCase = true) -> "No Internet Connection"

        message.contains("server", ignoreCase = true) -> "Server Error"
        message.contains("timeout", ignoreCase = true) -> "Request Timeout"
        else -> "Oops! Something went wrong"
    }

    ErrorContent(
        icon = icon,
        title = title,
        message = message,
        isRetry = isRetry,
        onRetry = onRetry,
        modifier = modifier
    )
}

/**
 * Generic error content layout
 */
@Composable
private fun ErrorContent(
    icon: ImageVector,
    title: String,
    message: String,
    isRetry: Boolean,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Error Icon
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(120.dp),
            tint = MaterialTheme.colorScheme.error.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Error Title
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Error Message
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )

        if (isRetry) {
            Spacer(modifier = Modifier.height(32.dp))

            // Retry Button
            Button(
                onClick = onRetry,
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = "Try Again",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
