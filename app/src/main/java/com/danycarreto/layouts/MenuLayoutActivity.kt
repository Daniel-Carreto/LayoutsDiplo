package com.danycarreto.layouts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.danycarreto.layouts.ConstraintLayout.ConstraintLayoutActivity
import com.danycarreto.layouts.FrameLayout.FrameLayoutActivity
import com.danycarreto.layouts.RelativeLayout.MainActivity
import kotlinx.android.synthetic.main.activity_menu_layout.*

const val EXTRA_NAME = "extra_name"
const val EXTRA_ID = "extra_id"
const val REQUEST_RELATIVE = 101
const val REQUEST_FRAME = 102
const val REQUEST_CONSTRAINT = 103

class MenuLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_layout)

        btnRelativeLayout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(EXTRA_NAME,"relative")
            intent.putExtra(EXTRA_ID,1)
            //startActivity(intent)
            startActivityForResult(intent, REQUEST_RELATIVE)
        }

        btnFrameLayout.setOnClickListener {
            val intent = Intent(this, FrameLayoutActivity::class.java)
            intent.putExtra(EXTRA_NAME,"frame")
            intent.putExtra(EXTRA_ID,2)
            startActivity(intent)
        }

        btnConstraintLayout.setOnClickListener {
            val intent = Intent(this, ConstraintLayoutActivity::class.java)
            intent.putExtra(EXTRA_NAME,"constraint")
            intent.putExtra(EXTRA_ID,3)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_RELATIVE, REQUEST_FRAME, REQUEST_CONSTRAINT -> {
                    Toast.makeText(
                        this,
                        "Terminado ${data?.extras?.getString("type")}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

}
