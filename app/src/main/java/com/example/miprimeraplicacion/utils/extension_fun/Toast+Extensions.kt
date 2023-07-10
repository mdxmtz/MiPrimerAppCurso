package com.example.miprimeraplicacion.utils.extension_fun

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Activity.showToast(message: String) =
    android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()


fun Fragment.showToast(message: String) =
    android.widget.Toast.makeText(requireActivity(), message, android.widget.Toast.LENGTH_SHORT).show()


fun Context.showToast(message: String) =
    android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()