package com.example.listview

import android.content.Context
import android.os.Message
import androidx.appcompat.app.AlertDialog

class Dialog {
    fun showDialog(context: Context, message: String, onConfirm: () -> Unit){
        val dialog = AlertDialog.Builder(context)
            .setMessage(message)
            .setPositiveButton("Удалить"){dialog, _ ->
                onConfirm()
                dialog.dismiss()
            }
            .setNegativeButton("Отмена"){dialog, _ ->
                dialog.dismiss()
            }
            .create()
        dialog.show()
    }
}