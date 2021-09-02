package com.lid.recycleviewtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lid.recycleviewtest.ui.theme.RecyclerViewTestTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel> {
        MainViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerViewTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ListApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun ListApp(viewModel: MainViewModel) {
    val itemList by viewModel.itemList.observeAsState(emptyList())

    Scaffold(
        topBar = { CustomAppBar("RecyclerViewTest: Jetpack Compose") }
    ) {
        ItemList(itemList) { viewModel.removeItem(it) }
    }
}

@Composable
fun CustomAppBar(title: String) {
    TopAppBar() {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun ItemList(itemsList: List<Int>, onClick: (Int) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = itemsList) { item ->
            ItemCard(item, onClick)
        }
    }
}

@Composable
fun ItemCard(item: Int, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .height(110.dp)
            .fillMaxWidth()
            .clickable { onClick(item) }
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = item.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 15.dp)
            )
        }
    }
}