package com.miguelsantos.calculadora

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalc = main_button_calc

        btnCalc.setOnClickListener {
            if (main_first_grade.text.isNullOrEmpty() ||
                main_second_grade.text.isNullOrEmpty() ||
                main_absents.text.isNullOrEmpty()
            ) {
                Toast.makeText(this, "Preencha todos os campos primeiro", Toast.LENGTH_SHORT).show()
            } else {
                val firstGrade = Integer.parseInt(main_first_grade.text.toString())
                val secondGrade = Integer.parseInt(main_second_grade.text.toString())
                val average = (firstGrade + secondGrade) / 2
                val absents = Integer.parseInt(main_absents.text.toString())

                val alertDialog: AlertDialog = this.let {
                    val builder = AlertDialog.Builder(it)

                    builder.apply {
                        if (average >= 6 && absents <= 10)
                            setTitle(R.string.approved)
                        else
                            setTitle(R.string.disapproved)

                        setMessage("Nota final: $average \nN° de faltas: $absents")
                        setPositiveButton(android.R.string.ok) { dialog, _ -> dialog.dismiss() }
                    }
                    builder.create()
                }

                alertDialog.show()
            }
        }
    }

}

