package com.example.user.kalk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Listener Angka agar dapat ditekan

        btn00.setOnClickListener { appenOnClick(true, "00") }
        btnNol.setOnClickListener { appenOnClick(true, "0") }
        btnSatu.setOnClickListener { appenOnClick(true, "1") }
        btnDua.setOnClickListener { appenOnClick(true, "2") }
        btnTiga.setOnClickListener { appenOnClick(true, "3") }
        btnEmpat.setOnClickListener { appenOnClick(true, "4") }
        btnLima.setOnClickListener { appenOnClick(true, "5") }
        btnEnam.setOnClickListener { appenOnClick(true, "6") }
        btnTujuh.setOnClickListener { appenOnClick(true, "7") }
        btnDelapan.setOnClickListener { appenOnClick(true, "8") }
        btnSembilan.setOnClickListener { appenOnClick(true, "9") }
        btnTitik.setOnClickListener { appenOnClick(true, ".") }

        //Operator
        kali.setOnClickListener { appenOnClick(false, "*") }
        bagi.setOnClickListener { appenOnClick(false, "/") }
        kurang.setOnClickListener { appenOnClick(false, "-") }
        tambah.setOnClickListener { appenOnClick(false, "+") }
        ttpKurung.setOnClickListener { appenOnClick(false, ")") }
        bukaKrng.setOnClickListener { appenOnClick(false, "(") }

        clear.setOnClickListener {
            clear()
        }

        hasil.setOnClickListener {
            hitung()
        }

        actionBack.setOnClickListener { back() }
    }


    // buat Method untuk menampilkan hasil
    private fun appenOnClick(hapus: Boolean, string: String) {

        if (hapus) {
            txtHasil.text = ""
            txtInput.append(string)
        } else {
            txtInput.append(txtHasil.text)
            txtInput.append(string)
            txtHasil.text = ""
        }

    }

    private fun clear() {
        txtInput.text = " "
        txtHasil.text = " "
    }

    private fun hitung() {
        try {

            val input = ExpressionBuilder(txtInput.text.toString()).build()
            val output = input.evaluate()
            val inputLong = output.toLong()

            if (output == inputLong.toDouble()) {
                txtHasil.text = inputLong.toString()
            } else {
                txtHasil.text = output.toString()
            }

        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun back() {

        val expression = txtInput.text.toString()
        if (expression.isNotEmpty()) {
            txtInput.text = expression.substring(0, expression.length - 1)
        }
    }
}