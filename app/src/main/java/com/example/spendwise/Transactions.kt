package com.example.spendwise

data class Transactions(
    val id:Int,
    var name: String,
    var amount: Double,
    var date: String
)

val transactionList = listOf(
    Transactions(1,"Sushant", 1250.50, "15-11-2023"),
    Transactions(2,"John", 800.0, "16-11-2023"),
    Transactions(3,"Alice", 150.75, "17-11-2023"),
    Transactions(4,"Bob", 300.25, "18-11-2023"),
    Transactions(5,"Eva", 950.0, "19-11-2023"),
    Transactions(6,"Mike", 550.50, "20-11-2023"),
    Transactions(7,"Lily", 200.0, "21-11-2023"),
    Transactions(8,"David", 700.75, "22-11-2023"),
    Transactions(9,"Sophia", 400.25, "23-11-2023"),
    Transactions(10,"Chris", 1200.0, "24-11-2023")
)