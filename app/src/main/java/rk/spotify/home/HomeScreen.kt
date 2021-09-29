package rk.spotify.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LibraryMusic
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rk.spotify.R
import rk.spotify.ui.theme.*

@Composable
fun HomeScreen() {
    HomeContent()

}

@Composable
fun HomeContent() {
    BottomBar()
}

enum class Tab(
    val label: Int,
    val icon: ImageVector,
) {
    HOME(R.string.home, Icons.Rounded.Home),
    SEARCH(R.string.search, Icons.Rounded.Search),
    LIBRARY(R.string.library, Icons.Rounded.LibraryMusic)
}

@Composable
fun BottomBar() {
    var tabSelectedIndex by remember { mutableStateOf(0) }
    Scaffold(
        bottomBar = {
            BottomNavigation {
                for (tab in Tab.values()) {
                    BottomNavigationItem(
                        selected = tabSelectedIndex == tab.ordinal,
                        onClick = { tabSelectedIndex = tab.ordinal },
                        icon = {
                            Icon(imageVector = tab.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = tab.label))
                        }
                    )
                }
            }
        }
    ) { padding ->

        ListContent(padding)

    }

}

@Composable
fun Header() {
    Box {
        HeaderGradient()
        Column {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 16.dp)) {
                Text(
                    text = "Good afternoon",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                        .align(alignment = Alignment.CenterVertically)
                )
                IconButton(
                    onClick = { /*TODO*/ },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = null
                    )

                }
                IconButton(
                    onClick = { /*TODO*/ },
                ) {
                    Icon(imageVector = Icons.Outlined.History,
                        contentDescription = null)

                }
                IconButton(
                    onClick = { /*TODO*/ },
                ) {
                    Icon(imageVector = Icons.Outlined.Settings,
                        contentDescription = null)

                }


            }
            RecentContent()
        }

    }


}

@Composable
fun RecentContent() {
    Column(modifier = Modifier.padding(8.dp)) {
        Row() {
            HeaderCard(
                image = painterResource(id = R.drawable.dance),
                name = "Dance & EDM",
                modifier = Modifier.weight(1f)
            )
            HeaderCard(
                image = painterResource(id = R.drawable.image),
                name = "Country Rocks",
                modifier = Modifier.weight(1f)
            )
        }
        Row() {
            HeaderCard(
                image = painterResource(id = R.drawable.image_1),
                name = "Indie",
                modifier = Modifier.weight(1f)
            )
            HeaderCard(
                image = painterResource(id = R.drawable.image_2),
                name = "Chilled Hits",
                modifier = Modifier.weight(1f)
            )
        }
        Row() {
            HeaderCard(
                image = painterResource(id = R.drawable.image_3),
                name = "Electronics",
                modifier = Modifier.weight(1f)
            )
            HeaderCard(
                image = painterResource(id = R.drawable.image_4),
                name = "Are & Be",
                modifier = Modifier.weight(1f)
            )
        }

    }
}

@Composable
fun HeaderCard(
    modifier: Modifier = Modifier,
    image: Painter,
    name: String,
) {
    Card(
        shape = RoundedCornerShape(6.dp),
        modifier = modifier.padding(4.dp)
    ) {
        Row(
            Modifier.clickable { },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
            )
            Text(
                text = name,
                style = MaterialTheme.typography.body2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            )
        }

    }

}

@Composable
fun ListContent(paddingValues: PaddingValues) {
    LazyColumn(contentPadding = paddingValues) {
        item {
            Header()
        }

        item {
            Title(title = "Recently played")
            LazyRow(content = {
                item {
                    RecentCard(image = painterResource(id = R.drawable.recent_1),
                        text = "Chilled Hits")

                }
                item {
                    RecentCard(image = painterResource(id = R.drawable.recent_2),
                        text = "Study Beats")

                }
                item {
                    RecentCard(image = painterResource(id = R.drawable.recent_3),
                        text = "Chill As Folk")

                }

            })

        }
        item {
            Column {
                Title(title = "Made For you")
                LazyRow(content = {
                    item {
                        PlaylistCard(
                            image = painterResource(id = R.drawable.art1),
                            title = "Sefareshi",
                            subtitle = "Single: Yas"
                        )
                    }

                    item {
                        PlaylistCard(
                            image = painterResource(id = R.drawable.art2),
                            title = "Batel Shod",
                            subtitle = "Single: Reza Pishro"
                        )
                    }

                    item {
                        PlaylistCard(
                            image = painterResource(id = R.drawable.art3),
                            title = "Fasle Zeshti",
                            subtitle = "Single: Daniyal,Pishro"
                        )
                    }
                })

            }
        }

    }

}

@Composable
fun Title(title: String) {
    Text(text = title,
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(16.dp))
}

@Composable
fun PlaylistCard(
    image: Painter,
    title: String,
    subtitle: String,
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 48.dp)) {
        Image(painter = image, contentDescription = null,
            modifier = Modifier
                .size(150.dp)
        )
        Text(text = title,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(top = 8.dp))
        Text(text = subtitle,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(top = 4.dp))
    }

}

@Composable
fun HeaderGradient() {
    GradientCircle(
        listOf(
            generateRandomColor(),
            Color.Transparent
        )
    )
}


@Composable
fun RecentCard(image: Painter, text: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(painter = image, contentDescription = null,
            modifier = Modifier
                .size(120.dp)
        )
        Text(text = text,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(top = 8.dp))
    }

}

fun generateRandomColor() = listOf(
    Purple200,
    Green,
    BlueYonder,
    Lavender,
    Olive,
    VioletBlue,
    YaleBlue,
    CGBlue,
    Wine,
    FireOpal,
    DarkPurple,
    PurpleNavy,
    Zomp,
    Auburn,
    Ruby

).random()


@Preview
@Composable
fun HomePreview() {
    SpotifyTheme() {
        HomeContent()


    }
}
