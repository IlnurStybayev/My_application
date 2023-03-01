package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_sixth.*
import kotlinx.android.synthetic.main.activity_tenth.*

class TenthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenth)
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want add Mister Poop to your contacts list?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You added Mr.Poop to your contact list", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(
                    this,
                    "You didn't add Mr.Poop to your contact list",
                    Toast.LENGTH_SHORT
                ).show()
            }.create()

        btnDialog1.setOnClickListener {
            addContactDialog.show()
        }
        val options = arrayOf("First Item", "Second Item", "Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(options, 0) { dialogInterface, i ->
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted the SingleChoseDialog", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined the SingleChoseDialog", Toast.LENGTH_SHORT)
                    .show()
            }.create()
        btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted the MultiChoseDialog", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined the MultiChoseDialog", Toast.LENGTH_SHORT)
                    .show()
            }.create()
        btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }

        btnBack10.setOnClickListener {
            finish()
        }

    }
}


