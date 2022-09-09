package com.example.sem4_act2

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val CAMERA_REQUEST = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btcamara=findViewById<Button>(R.id.btPermisos)

        btcamara.setOnClickListener {
            checkCameraPermission()
        }
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)
            !=PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this,"No hay permiso",Toast.LENGTH_LONG).show()
            requestCameraPermission()
        }
        else {
            Toast.makeText(this,"Ya hay permiso",Toast.LENGTH_LONG).show()
        }
    }

    private fun requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA))
            Toast.makeText(this,"Realizar pedido manualmente",Toast.LENGTH_LONG).show()
        else ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),CAMERA_REQUEST)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            CAMERA_REQUEST->{
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this,"Permiso otorgado",Toast.LENGTH_LONG).show()
                else Toast.makeText(this,"Permiso negado",Toast.LENGTH_LONG).show()
                return
            }
        }
    }
}