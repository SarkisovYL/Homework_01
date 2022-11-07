package com.example.homework01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.homework01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var counter: Int = 0
    val maxSeats: Int = 50
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)

        binder.countText.text = counter.toString()
        binder.buttonMinus.isEnabled = false

        binder.buttonPlus.setOnClickListener {
            counter++
            binder.countText.text = counter.toString()
            if (counter == maxSeats) {
                binder.buttonReset.visibility = View.VISIBLE
                binder.buttonPlus.isEnabled = false
                binder.messageText.setTextColor(Color.RED)
                binder.messageText.text = getString(R.string.text_end)
            } else {
                binder.buttonMinus.isEnabled = true
                binder.buttonReset.visibility = View.INVISIBLE
                binder.messageText.text = getString(R.string.text_process) + (maxSeats-counter).toString()
            }
        }

        binder.buttonMinus.setOnClickListener {
            counter--
            binder.countText.text = counter.toString()
            if (counter == 0) {
                binder.buttonMinus.isEnabled = false
                binder.buttonReset.visibility = View.INVISIBLE
                binder.messageText.text = getString(R.string.text_begin)
            } else {
                binder.buttonPlus.isEnabled = true
                binder.buttonReset.visibility = View.INVISIBLE
//                binder.messageText.setTextColor(resources.getColor(R.color.green, null)) для API > 23
                binder.messageText.setTextColor(Color.GREEN)
                binder.messageText.text = getString(R.string.text_process) + (maxSeats-counter).toString()
            }
        }

        binder.buttonReset.setOnClickListener {
            counter = 0
            binder.messageText.text = getString(R.string.text_begin)
            binder.buttonReset.visibility = View.INVISIBLE
            binder.countText.text = counter.toString()
            binder.buttonPlus.isEnabled = true
            binder.buttonMinus.isEnabled = false
            binder.messageText.setTextColor(Color.GREEN)
        }
    }
}