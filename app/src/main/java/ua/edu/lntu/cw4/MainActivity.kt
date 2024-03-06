package ua.edu.lntu.cw4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ua.edu.lntu.cw4.data.Datasource
import ua.edu.lntu.cw4.model.ItemList
import ua.edu.lntu.cw4.ui.theme.IPZ_CR_4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            IPZ_CR_4Theme {
                // A surface container using the 'background' color from the theme
                NavHost(
                    navController = navController,
                    startDestination = "listscreen"
                ) {
                    composable("listscreen") {
                        InfoList(informationList = Datasource().loadInformation(), modifier = Modifier) {
                            navController.navigate("itemscreen")
                        }
                    }
                    composable("itemscreen") {
                        ItemScreen(number = 1)
                    }
                }
            }
        }
    }
}

// InfoList(informationList = Datasource().loadInformation(), modifier = Modifier)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(information: ItemList, modifier: Modifier, onClick: () -> Unit) {
    Card(
        modifier = modifier,
        onClick = {onClick()}
    ) {
        Column(modifier.padding(10.dp)) {
            Text(text = "${information.number}", fontSize = 40.sp)
            Spacer(modifier.height(3.dp))
            Text(text = information.name)
        }
    }
}

@Composable
fun InfoList(informationList: List<ItemList>, modifier: Modifier, onClick: () -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(1), userScrollEnabled = true) {
        items(informationList) {
                information -> Content(
            information = information,
            modifier = Modifier,
            onClick = onClick)
        }
    }
}

@Composable
fun ItemScreen(number: Int) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Text("${number}", fontSize = 500.sp)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InfoPreview() {
    IPZ_CR_4Theme {
        ItemScreen(number = 2)
    }
}