package com.example.jadwalbis20.model

sealed class BusItem {
    data class Header(val title: String) : BusItem()
    data class BusInfo(
        val id: Int,
        val name: String,
        val departureTime: String,
        val arrivalTime: String,
        val destination: String,
        val type: String = "Reguler",
        val color: String = "#2C2C2C"
    ) : BusItem()
}
