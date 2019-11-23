package com.danycarreto.layouts.Alerts

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.danycarreto.layouts.R
import kotlinx.android.synthetic.main.activity_alerts.*

class AlertsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alerts)

        btnAlertDialog.setOnClickListener {
            showAlertDialog()
        }

        btnAlertCustom.setOnClickListener {
            showAlertCustomDialog()
        }

    }


    fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Espera")
        alertDialog.setMessage("El dispositivo no tiene internet")
        alertDialog.setIcon(R.mipmap.ic_launcher)
        alertDialog.setNeutralButton("Entendido",
            object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {

                }
            })
        alertDialog.setPositiveButton("Aceptar",
            object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {

                }
            })
        alertDialog.setNegativeButton("Cancelar",
            object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {

                }
            })
        alertDialog.setCancelable(false)
        alertDialog.create()
        alertDialog.show()
    }

    fun showAlertCustomDialog() {
        val layoutInflater = LayoutInflater.from(this)
        val viewDialog = layoutInflater.inflate(R.layout.custom_dialog, null)
        val dialog = AlertDialog.Builder(this).create()
        dialog.setView(viewDialog)
        viewDialog.findViewById<TextView>(R.id.txtTitleDialog)
            .text = "¡Atención!"
        viewDialog.findViewById<TextView>(R.id.txtMessageDialog)
            .text = "El dispositivo no cuenta con internet"
        viewDialog.findViewById<Button>(R.id.btnAcceptDialog).setOnClickListener {
            dialog.dismiss()
        }
        dialog.setCancelable(false)
        dialog.show()
    }
}
