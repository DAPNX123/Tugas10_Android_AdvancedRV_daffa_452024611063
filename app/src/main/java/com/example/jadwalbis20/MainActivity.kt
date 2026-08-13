package com.example.jadwalbis20

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jadwalbis20.adapter.BusListAdapter
import com.example.jadwalbis20.databinding.ActivityMainBinding
import com.example.jadwalbis20.model.BusItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = BusListAdapter()
    private val scheduleList = mutableListOf<BusItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupListeners()
        loadInitialData()
    }

    private fun setupRecyclerView() {
        // Switching to LinearLayoutManager to match the flat list look in the screenshot
        binding.rvBus.layoutManager = LinearLayoutManager(this)
        binding.rvBus.adapter = adapter
    }

    private fun setupListeners() {
        binding.btnSubmit.setOnClickListener {
            val name = binding.etBusName.text.toString()
            val departure = binding.etDeparture.text.toString()
            val arrival = binding.etArrival.text.toString()
            val destination = binding.etDestination.text.toString()

            if (name.isNotEmpty() && departure.isNotEmpty() && arrival.isNotEmpty() && destination.isNotEmpty()) {
                val newBus = BusItem.BusInfo(
                    id = System.currentTimeMillis().toInt(),
                    name = name,
                    departureTime = departure,
                    arrivalTime = arrival,
                    destination = destination
                )
                
                scheduleList.add(newBus)
                adapter.submitList(scheduleList.toList())
                
                // Clear inputs
                binding.etBusName.text.clear()
                binding.etDeparture.text.clear()
                binding.etArrival.text.clear()
                binding.etDestination.text.clear()
                
                Toast.makeText(this, "Jadwal ditambahkan", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadInitialData() {
        scheduleList.addAll(listOf(
            BusItem.BusInfo(1, "Harapan Jaya", "15 : 00", "04 : 00", "Ponorogo"),
            BusItem.BusInfo(2, "Handoyo", "16 : 00", "01 : 00", "Jogjakarta"),
            BusItem.BusInfo(3, "Budiman", "17 : 00", "23 : 00", "garut")
        ))
        adapter.submitList(scheduleList.toList())
    }
}
