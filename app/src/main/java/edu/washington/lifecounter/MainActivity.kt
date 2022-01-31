package edu.washington.lifecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myLifeValues = LinkedHashMap<Int, Int>()
        myLifeValues[1] = 20;
        myLifeValues[2] = 20;
        myLifeValues[3] = 20;
        myLifeValues[4] = 20;


        val lifep1 = findViewById<TextView>(R.id.lifep1)
        val lifep2 = findViewById<TextView>(R.id.lifep2)
        val lifep3 = findViewById<TextView>(R.id.lifep3)
        val lifep4 = findViewById<TextView>(R.id.lifep4)

        val myTextView = findViewById<TextView>(R.id.textView)

        fun setLPValues() {
            lifep1.text = "p1\n" + String.format("%03d",myLifeValues[1]);
            lifep2.text = "p2\n" + String.format("%03d",myLifeValues[2]);
            lifep3.text = "p3\n" + String.format("%03d",myLifeValues[3]);
            lifep4.text = "p4\n" + String.format("%03d",myLifeValues[4]);
        }
        setLPValues();

        fun setLoserMessage(player : Int) {
            myTextView.text = "Player " + player +" LOSES!"
        }

        fun btnListener (it : View) {
            val currentBtn= it as Button;
            val currentPlayerInt = ((currentBtn.tag as String).substring(1,2).toInt());
            var modifier = 1;
            if((currentBtn.tag as String).substring(2,3) == "m")
                modifier = -1;
            val netChange = (currentBtn.tag as String).substring(3,4).toInt()
            myLifeValues[currentPlayerInt] = (myLifeValues[currentPlayerInt] as Int) + (modifier * netChange);

            if(myLifeValues[currentPlayerInt] as Int > 999)
            {
                myLifeValues[currentPlayerInt] = 999
            }

            if((myLifeValues[currentPlayerInt] as Int) < 0)
            {
                myLifeValues[currentPlayerInt] = 0
            }
            setLPValues();

            if((myLifeValues[currentPlayerInt] as Int) == 0)
            {
                setLoserMessage(currentPlayerInt);
            }
        }

        findViewById<Button>(R.id.p3p1).setOnClickListener {btnListener(it)};
        findViewById<Button>(R.id.p3m1).setOnClickListener {btnListener(it)};
        findViewById<Button>(R.id.p3p5).setOnClickListener {btnListener(it)};
        findViewById<Button>(R.id.p3m5).setOnClickListener {btnListener(it)};

        findViewById<Button>(R.id.p1p1).setOnClickListener {btnListener(it)};
        findViewById<Button>(R.id.p1m1).setOnClickListener {btnListener(it)};
        findViewById<Button>(R.id.p1p5).setOnClickListener {btnListener(it)};
        findViewById<Button>(R.id.p1m5).setOnClickListener {btnListener(it)};

        findViewById<Button>(R.id.p2p1).setOnClickListener {btnListener(it)};
        findViewById<Button>(R.id.p2m1).setOnClickListener {btnListener(it)};
        findViewById<Button>(R.id.p2p5).setOnClickListener {btnListener(it)};
        findViewById<Button>(R.id.p2m5).setOnClickListener {btnListener(it)};

        findViewById<Button>(R.id.p4p1).setOnClickListener {btnListener(it)};
        findViewById<Button>(R.id.p4m1).setOnClickListener {btnListener(it)};
        findViewById<Button>(R.id.p4p5).setOnClickListener {btnListener(it)};
        findViewById<Button>(R.id.p4m5).setOnClickListener {btnListener(it)};
    }
}