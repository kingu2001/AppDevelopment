package com.example.pdfviewer

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import com.example.pdfviewer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOpenPDF.setOnClickListener {
            // Load PDF from the assets folder
            val assetFileName = "Beskrivelse.pdf" // Replace with your PDF file name
            loadPDFFromAssets(assetFileName)
        }
    }

    private fun loadPDFFromAssets(fileName: String) {
        try {
            val inputStream = assets.open(fileName)
            binding.pdfView.fromStream(inputStream)
                .spacing(12)
                .defaultPage(0)
                .enableAnnotationRendering(false)
                .enableDoubletap(true)
                .load()
            binding.pdfView.fitToWidth()
            binding.pdfView.useBestQuality(true)
        } catch (e: Exception) {
            // Handle exceptions
        }
    }
}