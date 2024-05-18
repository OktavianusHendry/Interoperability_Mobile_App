package com.okta.interoperability

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.okta.interoperability.ui.MainViewModel
import com.okta.interoperability.ui.theme.InteroperabilityTheme
import com.okta.interoperability.ui.theme.PurpleMain

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InteroperabilityTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val listData by viewModel.listData.collectAsState()
                    val listBonangData by viewModel.listBonangData.collectAsState()
                    Column {
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                        ) {
                            items(listData) { item ->
                                val imageUrl =
                                    "https://kelompok1.doseninformatika.com/produkApi/" + (item.gambar
                                        ?: "")
                                val painter = rememberAsyncImagePainter(model = imageUrl)
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(
                                            width = 2.dp,
                                            color = Color.Gray,
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(16.dp)
                                ) {
                                    Image(
                                        painter = painter,
                                        contentDescription = "Image of ${item.nama}",
                                        modifier = Modifier
                                            .size(150.dp)
                                            .fillMaxWidth(),
                                    )
                                    Text(
                                        text = (item.brand + " - " + item.nama) ?: "",
                                        style = MaterialTheme.typography.titleMedium,
                                        modifier = Modifier
                                            .padding(bottom = 8.dp)
                                    )
                                    Text(
                                        text = "Rp" + item.harga,
                                        style = MaterialTheme.typography.labelLarge,
                                        color = PurpleMain
                                    )
                                    Text(
                                        text = item.seller ?: "",
                                        style = MaterialTheme.typography.bodySmall,
                                    )
                                }
                            }
                        }

                        Text(
                            text = "Kelompok Alfred",
                            modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
                        )
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                        ) {
                            items(listBonangData) { item ->
                                val imageUrl =
                                    "https://kelompok2.doseninformatika.com/" + (item.gambar
                                        ?: "")
                                val painter = rememberAsyncImagePainter(model = imageUrl)
                                Column(
                                    modifier = Modifier
                                        .width(150.dp)
                                        .border(
                                            width = 2.dp,
                                            color = Color.Gray,
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(16.dp)
                                ) {
                                    Image(
                                        painter = painter,
                                        contentDescription = "Image of ${item.gambar}",
                                        modifier = Modifier
                                            .size(150.dp)
                                            .fillMaxWidth(),
                                    )
                                    Text(
                                        text = (item.nama) ?: "",
                                        style = MaterialTheme.typography.titleMedium,
                                        modifier = Modifier
                                            .padding(bottom = 8.dp)
                                    )
                                    Text(
                                        text = "Rp" + item.harga,
                                        style = MaterialTheme.typography.labelLarge,
                                        color = PurpleMain
                                    )
                                    Text(
                                        text = item.deskripsi ?: "",
                                        style = MaterialTheme.typography.bodySmall,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

