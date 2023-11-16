package com.example.spendwise

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.CardDefaults.shape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults.containerColor
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(navHostController: NavHostController) {
    var totalBudget: Double = 15000.00
    var income: Double = 2599.00
    var spend: Double = 4902.75
    var avail: Double = income + (totalBudget - spend)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(10.dp, 0.dp)
    ) {
        Text(
            text = "Available Budget",
            fontSize = 25.sp
        )
        Text(
            text = "₹$avail",
            fontWeight = Bold,
            fontSize = 50.sp

        )
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Card(
                modifier = Modifier
                    .weight(1f),
                shape = RoundedCornerShape(5.dp),
                elevation = CardDefaults.cardElevation(5.dp),
                colors = cardColors(
                    Color.Green
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Income"
                    )
                    Text(
                        fontWeight = Bold,
                        text = "+₹$income",
                        fontSize = 30.sp
                    )
                }

            }
            Spacer(modifier = Modifier.size(10.dp))
            Card(
                modifier = Modifier
                    .weight(1f),
                shape = RoundedCornerShape(5.dp),
                elevation = CardDefaults.cardElevation(5.dp),
                colors = cardColors(
                    Color.Red
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp),
                ) {
                    Text("Spend")
                    Text(
                        fontWeight = Bold,
                        text = "-₹$spend",
                        fontSize = 30.sp
                    )
                }

            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        Column(
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(text = "Recent Transactions")
            Spacer(modifier = Modifier.size(10.dp))

            LazyColumn(
                modifier = Modifier.padding(bottom = 15.dp, top = 0.dp)
            ) {
                this.items(transactionList) { transaction ->
                    transactionUi(
                        name = transaction.name,
                        amount = transaction.amount,
                        date = transaction.date,
                        direction = transaction.direction
                    )
                }
            }

        }

    }

}


@Composable
fun transactionUi(
    name: String,
    amount: Double,
    date: String,
    direction: Boolean
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    fontSize = 20.sp,
                    fontWeight = Bold,
                    text = "$name"
                )
                if (direction){
                    Text(
                        fontSize = 20.sp,
                        fontWeight = Bold,
                        text = "-₹$amount",
                        color = Color.Red
                    )
                } else {
                    Text(
                        fontSize = 20.sp,
                        fontWeight = Bold,
                        text = "+₹$amount",
                        color = Color.Green
                    )
                }

            }
            Text(text = "$date")

        }
    }
    Spacer(modifier = Modifier.size(10.dp))
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
    )


}