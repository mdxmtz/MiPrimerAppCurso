package com.example.miprimeraplicacion.utils.extension_fun

import android.app.Activity
import android.widget.Toast

fun Activity.showToast(message: String) =
    android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
