package com.example.xmlnavapp1

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.xmlnavapp1.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {

    private lateinit var binding: ActivityBBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val message = intent.getStringExtra("key")
        val parcelizedUser = intent.getParcelableExtra("USER_KEY", User::class.java)

        binding.tvActivityB.text = message
        val parcelizedMsg = "${parcelizedUser?.name} + ${parcelizedUser?.age.toString()}"
        binding.tvParcelizeActivityB.text = parcelizedMsg
    }
}