package com.beam.businesscard.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Dark theme
private val DarkColorScheme = darkColorScheme(
    primary = AndroidGreen,
    onPrimary = Color.Black,
    secondary = SubtitleGreen,
    onSecondary = Color.Black,
    background = DarkBlue,
    onBackground = Color.White,
    surface = LightGreen,
    onSurface = Color.White,
    tertiary = IconGreen
)

// Light theme
private val LightColorScheme = lightColorScheme(
    primary = AndroidGreen,
    onPrimary = Color.White,
    secondary = SubtitleGreen,
    onSecondary = Color.White,
    background = LightGreen,
    onBackground = BlackText,
    surface = DarkBlue,
    onSurface = BlackText,
    tertiary = IconGreen
)

@Composable
fun BusinessCardTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
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
