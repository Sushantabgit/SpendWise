package com.example.spendwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spendwise.ui.theme.SpendWiseTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent(navController = rememberNavController())
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        modifier = Modifier
            .height(60.dp)
    ) {
        NavigationBarItem(
            selected = navController.currentDestination?.route == "HomeScreen",
            onClick = {
                navController.navigate("HomeScreen")
            },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
        )

        NavigationBarItem(
            selected = navController.currentDestination?.route == "TransactionScreen",
            onClick = {
                navController.navigate("TransactionScreen")
            },
            icon = {
                Icon(imageVector = Icons.Default.List, contentDescription = "Transactions")
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    /*Todo*/
                },
                shape = RoundedCornerShape(50)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "HomeScreen",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("HomeScreen") {
                homeScreen(navController)
            }
            composable("TransactionScreen") {
                allTransactions(navController)
            }
        }
    }
}