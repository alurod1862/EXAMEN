package com.example.examen.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.examen.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun portada(navController: NavController) {
    Column {
        Spacer(modifier = Modifier.height(65.dp))

        val items3 = listOf(
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
        )

        val items = listOf(
            "Morella",
            "Lugo",
            "Bangkok",
            "Peru",
            "Pekin",
            "Granada",
            "Atenas",
            "Yucatan",
            "Seychelles",
        )

        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2)) {
            items(items3.size) { index ->
                Box(
                    modifier = Modifier.padding(5.dp)
                ) {
                    Image(
                        painter = painterResource(id = items3[index]),
                        contentDescription = "1",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate("Ciudad/${items[index]}")
                            },
                        contentScale = ContentScale.Crop,
                    )
                    TopAppBar(
                        title = { Text(items[index], color = Color.White, textDecoration = TextDecoration.Underline) },
                    )
                }
            }
        }
    }
}


@Composable
fun ciudadSeleccionada(nombreCiudad: String?) {

    val colorStops = arrayOf(
        0.0f to Color.White,
        0.2f to Color.Cyan,
        1f to Color.Blue
    )


    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Brush.horizontalGradient(colorStops = colorStops))
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier
                //.height(100.dp)
                //.padding(top = 15.dp)
        ) {
            Text(
                text = "$nombreCiudad",
                fontFamily = saltyocen,
                fontSize = 65.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
        }

        val imagenId = when (nombreCiudad) {
            "Morella" -> R.drawable.image
            "Lugo" -> R.drawable.image1
            "Bangkok" -> R.drawable.image2
            "Peru" -> R.drawable.image3
            "Pekin" -> R.drawable.image4
            "Granada" -> R.drawable.image5
            "Atenas" -> R.drawable.image6
            "Yucatan" -> R.drawable.image7
            "Seychelles" -> R.drawable.image8
            else -> R.drawable.image
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = imagenId),
                contentDescription = "1",
                modifier = Modifier
                    .padding(100.dp)
                    .width(200.dp)
                    .height(300.dp),
                //.blur(radiusX = 10.dp,
                //radiusY = 10.dp,
                //edgeTreatment = BlurredEdgeTreatment.Unbounded),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }
    }
}