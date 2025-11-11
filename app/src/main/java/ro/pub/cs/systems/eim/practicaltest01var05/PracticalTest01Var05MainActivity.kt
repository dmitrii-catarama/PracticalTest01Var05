package ro.pub.cs.systems.eim.practicaltest01var05

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class PracticalTest01Var05MainActivity : AppCompatActivity() {

    private lateinit var text1: TextView
    private lateinit var clickCounter: TextView

    var countClick1 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var05_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val serviceIntent = Intent(this, PracticalTestService::class.java)
        startService(serviceIntent)

        text1 = findViewById(R.id.text1)
        text1.setText("")

        clickCounter = findViewById(R.id.clickCounter)
        clickCounter.setText("")


        val topLeftButton = findViewById<Button>(R.id.button)
        topLeftButton.setOnClickListener {
            text1.append("Top Left")
            countClick1++
            clickCounter.text = countClick1.toString()
            //text1.setText("TopLeft, Top Right, Center, Bottom Left, Bottom Right")
        }

        val topRightButton = findViewById<Button>(R.id.button2)
        topRightButton.setOnClickListener {
            text1.append(" Top Right")
            countClick1++
            clickCounter.text = countClick1.toString()
            //text1.setText("Top Left, TopRight, Center, Bottom Left, Bottom Right")
        }

        val bottomLeftButton = findViewById<Button>(R.id.button4)
        bottomLeftButton.setOnClickListener {
            text1.append(" Bottom Left")
            countClick1++
            clickCounter.text = countClick1.toString()
        }

        val bottomRightButton = findViewById<Button>(R.id.button5)
        bottomRightButton.setOnClickListener {
            text1.append(" Bottom Right")
            countClick1++
            clickCounter.text = countClick1.toString()
        }

        val centerButton = findViewById<Button>(R.id.button3)
        centerButton.setOnClickListener {
            text1.append(", Center")
            countClick1++
            clickCounter.text = countClick1.toString()
        }

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("CLICK")) {
                clickCounter.setText(savedInstanceState.getString("CLICK"))
            } else {
                clickCounter.setText("0");
            }
        } else {
            clickCounter.setText("0");
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("CLICK", clickCounter.getText().toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        if (savedInstanceState.containsKey("CLICK")) {
            clickCounter.setText(savedInstanceState.getString("CLICK"))
        } else {
            clickCounter.setText("0")
        }
    }
}