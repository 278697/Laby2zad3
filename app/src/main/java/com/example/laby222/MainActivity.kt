package com.example.laby222

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //Zmienna przechowująca stan licznika
    private var licznik = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sekcja: Imię
        val etName = findViewById<EditText>(R.id.etName)
        val btnReadName = findViewById<Button>(R.id.btnReadName)

        // Sekcja: Licznik
        val tvCounter = findViewById<TextView>(R.id.tvCounter)
        val btnAdd = findViewById<Button>(R.id.btnAdd)

        // Sekcja: Mnożenie
        val etNum1 = findViewById<EditText>(R.id.etNum1)
        val etNum2 = findViewById<EditText>(R.id.etNum2)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val tvResult = findViewById<TextView>(R.id.tvResult)


        // Akcja 1: Przycisk "ODCZYTAJ IMIĘ"
        btnReadName.setOnClickListener {
            val wpisaneImie = etName.text.toString()

            if (wpisaneImie.isNotEmpty()) {
                Toast.makeText(this, "Witaj, $wpisaneImie!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Najpierw wpisz imię!", Toast.LENGTH_SHORT).show()
            }
        }

        // Akcja 2: Przycisk "Dodaj 1"
        btnAdd.setOnClickListener {
            licznik++
            tvCounter.text = "Licznik wciśnięć przycisku: $licznik"
        }

        // Akcja 3: Przycisk "MNOŻENIE"
        btnMultiply.setOnClickListener {
            val tekstLiczba1 = etNum1.text.toString()
            val tekstLiczba2 = etNum2.text.toString()

            // Sprawdzamy, czy użytkownik na pewno coś wpisał
            if (tekstLiczba1.isNotEmpty() && tekstLiczba2.isNotEmpty()) {
                try {
                    // Zamieniamy tekst na liczby zmiennoprzecinkowe
                    val liczba1 = tekstLiczba1.toDouble()
                    val liczba2 = tekstLiczba2.toDouble()

                    // Mnożymy i wyświetlamy wynik
                    val wynik = liczba1 * liczba2
                    tvResult.text = wynik.toString()
                } catch (e: NumberFormatException) {
                    tvResult.text = "Błąd liczb!"
                }
            } else {
                tvResult.text = "Brak danych!"
            }
        }
    }
}