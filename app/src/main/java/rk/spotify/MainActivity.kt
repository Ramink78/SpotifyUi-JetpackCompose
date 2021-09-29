package rk.spotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import rk.spotify.home.HomeScreen
import rk.spotify.ui.theme.SpotifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyTheme {
                HomeScreen()
            }


        }
    }


}
