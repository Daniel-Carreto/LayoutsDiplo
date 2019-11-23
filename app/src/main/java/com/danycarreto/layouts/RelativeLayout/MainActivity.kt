package com.danycarreto.layouts.RelativeLayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.danycarreto.layouts.EXTRA_ID
import com.danycarreto.layouts.EXTRA_NAME
import com.danycarreto.layouts.R
import com.danycarreto.layouts.REQUEST_RELATIVE

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var name:String = ""
        var value:Int = 0
        intent.extras?.let {
            name = it.getString(EXTRA_NAME, "Default Principal")
            value = it.getInt(EXTRA_ID, 0)
        }
        Toast.makeText(this,
            "${MainActivity::class.java.simpleName} name: $name & value: $value",
            Toast.LENGTH_SHORT).show()

    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("type", "relative")
        setResult(REQUEST_RELATIVE, intent)
        finish()
    }


}
