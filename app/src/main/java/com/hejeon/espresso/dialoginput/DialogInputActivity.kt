package com.hejeon.espresso.dialoginput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.hejeon.espresso.R
import kotlinx.android.synthetic.main.activity_dialog_input.*

class DialogInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_input)

        openDialog.setOnClickListener {
            showInputDialog()
        }
    }

    private fun showInputDialog() {
        MaterialDialog(this)
            .show {
                input(
                    waitForPositiveButton = true,
                    allowEmpty = false
                ){ dialog, input ->
                    setTextView(input.toString())
                }
                title(text = getString(R.string.enter_text))
                positiveButton(text= getString(android.R.string.ok))
            }
    }

    private fun setTextView(dlgInput : String ){
        inputText.text = dlgInput
    }
}
