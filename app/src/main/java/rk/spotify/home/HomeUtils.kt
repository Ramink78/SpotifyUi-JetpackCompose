package rk.spotify.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun GradientCircle(
    colors: List<Color>,
) {
    BoxWithConstraints(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()


    ) {
        val center = Offset(0f, 0f)
        val radius = constraints.maxWidth.toFloat()
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(brush = Brush.radialGradient(
                colors = colors,
                center = center,
                radius = radius/1.15f
            ),
                radius = radius,
                center = center)
        }


    }

}