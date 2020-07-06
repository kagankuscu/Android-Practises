package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private var operator = "*"
    private var oldNumber = ""
    private var newOperator = true

    fun btnWriteNumber(view: View) {
        if (newOperator) {
            txtDisplay.setText("")
        }
        newOperator = false

        var btnChoose = view as Button
        var btnValue = txtDisplay.text.toString()

        when (btnChoose.id) {
            btn0.id -> {
                btnValue += "0"
            }
            btn1.id -> {
                btnValue += "1"
            }
            btn2.id -> {
                btnValue += "2"
            }
            btn3.id -> {
                btnValue += "3"
            }
            btn4.id -> {
                btnValue += "4"
            }
            btn5.id -> {
                btnValue += "5"
            }
            btn6.id -> {
                btnValue += "6"
            }
            btn7.id -> {
                btnValue += "7"
            }
            btn8.id -> {
                btnValue += "8"
            }
            btn9.id -> {
                btnValue += "9"
            }
            btnMinus.id -> {
                btnValue = "-$btnValue"
            }
            btnDot.id -> {
                btnValue += "."
            }
        }
        txtDisplay.setText(btnValue)
    }

    fun btnOperator(view: View) {
        var btnOperatorChoose = view as Button
        when (btnOperatorChoose.id) {
            btnDivided.id -> {
                operator = "/"
            }
            btnMulti.id -> {
                operator = "x"
            }
            btnSub.id -> {
                operator = "-"
            }
            btnPlus.id -> {
                operator = "+"
            }
        }
        oldNumber = txtDisplay.text.toString()
        newOperator = true
    }

    fun btnEquals(view: View) {
        var newNumber = txtDisplay.text.toString()
        var result: Double? = null

        when(operator) {
            "/" -> {
                result = oldNumber.toDouble() / newNumber.toDouble()
            }
            "x" -> {
                result = oldNumber.toDouble() * newNumber.toDouble()
            }
            "-" -> {
                result = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                result = oldNumber.toDouble() + newNumber.toDouble()
            }
        }

        txtDisplay.setText(result.toString())
        newOperator = true
    }

}