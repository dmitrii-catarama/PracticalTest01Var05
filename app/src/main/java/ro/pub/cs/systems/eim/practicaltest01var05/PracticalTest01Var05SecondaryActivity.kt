package ro.pub.cs.systems.eim.practicaltest01var05

import android.os.Bundle

class PracticalTest01Var05SecondaryActivity {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        // extragem valorile trimise de la activitatea principala prin intent

        // ATENTIE LA TIPUL DE DATE, CUM SE TRIMIT IN INTENT ASA SE SI SCOT! ALTFEL NU SE PRIMESC
        //eu am trimis int si am scos int

        // aici am asignat field-ului "text" din xml-ul lui secondary activity valoarea.

        val sumButton = findViewById<Button>(R.id.button1)
        sumButton.setOnClickListener {
            val result = v1 + v2 + v3 + v4
            val resultIntent = Intent()
            resultIntent.putExtra("result", result.toString())
            setResult(RESULT_OK, resultIntent)
            finish()

        }
    }
}