package com.example.myapplication
import android.Manifest
import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.custom_toast.*
import kotlinx.android.synthetic.main.main_layout.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private var permissionsGranted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        updateButtonState()

        btnRequestPermissions.setOnClickListener {
            if (permissionsGranted) {
                removePermissions()
            } else {
                requestPermissions()
            }
        }
        btnTakePhoto.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "Image/*"
                startActivityForResult(it,0)
            }
        }

        btnOpenActivity1.setOnClickListener {
            Intent(this, FirstActivity::class.java).also {
                startActivity(it)
            }
        }
        btnOpenActivity2.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }
        btnOpenActivity3.setOnClickListener {
            Intent(this, ThirdActivity::class.java).also {
                startActivity(it)
            }
        }
        btnOpenActivity4.setOnClickListener {
            Intent(this, FourthActivity::class.java).also {
                startActivity(it)
            }
        }
        btnOpenActivity5.setOnClickListener {
            Intent(this, Fifth::class.java).also {
                startActivity(it)
            }
        }
        btnOpenActivity6.setOnClickListener {
            Intent(this, SixthActivity::class.java).also {
                startActivity(it)
            }
        }
        btnOpenActivity7.setOnClickListener {
            Intent(this, SeventhActivity::class.java).also {
                startActivity(it)
            }
        }
        btnEnter.setOnClickListener {
            finish()
        }

    }


private fun hasWriteExternalStoragePermission() =
    ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

private fun hasLocationForegroundPermission() =
    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

@TargetApi(30)
private fun hasLocationBackgroundPermission() =
    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

private fun requestPermissions() {
    var permissionsToRequest = mutableListOf<String>()

    if (!hasWriteExternalStoragePermission()) {
        permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    if (!hasLocationForegroundPermission()) {
        permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (hasLocationForegroundPermission() && !hasLocationBackgroundPermission()) {
            permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }
    }

    if (permissionsToRequest.isNotEmpty()) {
        ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
    } else {
        permissionsGranted = true
        showPermissionsGrantedAlert()
        updateButtonState()
    }
}

private fun removePermissions() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            ),
            0
        )
    } else {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
            0
        )
    }
    permissionsGranted = false
    updateButtonState()
}

private fun showPermissionsGrantedAlert() {
    val builder = AlertDialog.Builder(this)
    builder.setMessage("Permissions granted!")
    builder.setPositiveButton("OK") { dialog, _ ->
        dialog.dismiss()
    }
    val dialog = builder.create()
    dialog.show()
}

private fun updateButtonState() {
    if (permissionsGranted) {
        btnRequestPermissions.text = "Permissions"
        btnRequestPermissions.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
        btnRequestPermissions.isEnabled = false
    } else {
        btnRequestPermissions.text = "Permissions"
        btnRequestPermissions.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
        btnRequestPermissions.isEnabled = true
    }
}

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miAddContacts -> Toast.makeText(this,"You clicked on Add contacts", Toast.LENGTH_SHORT).show()
            R.id.miFavorites -> Toast.makeText(this,"You clicked on Favorites", Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this,"You clicked on Settings", Toast.LENGTH_SHORT).show()
            R.id.miClose -> finish()
            R.id.miFeedback -> Toast.makeText(this,"You clicked on Feedback", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 0){
            val uri = data?.data
            ivPhoto.setImageURI(uri)
        }
    }
override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    if (requestCode == 0 && grantResults.isNotEmpty()) {
        var allPermissionsGranted = true
        for (i in grantResults.indices) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                allPermissionsGranted = false
                Log.d("PermissionRequest", "${permissions[i]} not granted.")
            } else {
                Log.d("PermissionRequest", "${permissions[i]} granted.")
            }
        }

        if (allPermissionsGranted) {
            permissionsGranted = true
            showPermissionsGrantedAlert()
            updateButtonState()
        }
    }}}










