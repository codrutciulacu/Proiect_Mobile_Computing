package com.university.proiect.mobile.computing.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = DarkPeachyPrimary,
    secondary = PeachAmber,
    tertiary = SoftTeal,
    background = CleanDarkBackground,
    surface = CleanDarkSurface,
    surfaceVariant = CleanDarkSurfaceVariant,
    onSurface = CleanDarkOnSurface,
    onSurfaceVariant = CleanDarkOnSurfaceVariant
)

private val LightColorScheme = lightColorScheme(
    primary = PeachyPrimary,
    secondary = PeachAmber,
    tertiary = SoftTeal,
    primaryContainer = PeachyContainer,
    background = CleanLightBackground,
    surface = CleanLightSurface,
    surfaceVariant = CleanLightSurfaceVariant,
    onSurface = CleanLightOnSurface,
    onSurfaceVariant = CleanLightOnSurfaceVariant,
    outline = CleanLightOutline
)

@Composable
fun ProiectMobileComputingTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color false by default to showcase our peachy primary and clean light gray/white palette
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
