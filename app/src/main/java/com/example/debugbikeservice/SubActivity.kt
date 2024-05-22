package com.example.debugbikeservice

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Message
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.debugbikeservice.databinding.ActivitySubBinding
import kotlin.random.Random

class SubActivity : AppCompatActivity() {

    lateinit var subBinding: ActivitySubBinding ;
    var a : Int = (0 .. 100).random()
    var b : Int = (0 .. 100).random()

    var sub : Int  = a - b
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        subBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(subBinding.root)





        var life : Int = 3
        var score : Int = 0

        subBinding.lifeSpan.text = life.toString()
        subBinding.score.text = score.toString()

        object  : CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {

                subBinding.timer.text = (p0/1000).toString()
            }

            override fun onFinish() {
                subtract()
                life = life - 1 ;
                subBinding.lifeSpan.text =life.toString()


            }
        }

        subBinding.operand1.text = a.toString()
        subBinding.operand2.text = b.toString()


        if(life > 0){
        subBinding.checkButton.setOnClickListener {
            val ans: Int = subBinding.showScore.text.toString().toInt()
            if (ans == sub) {
                score = score + 10;
                subBinding.score.text  = score.toString()

                toast("Correct answer")
                subtract()




            } else {
                life = life - 1;
                subBinding.lifeSpan.text = life.toString()
            }
        }

            subBinding.nextButton.setOnClickListener {

                subtract()


            }

        }
        else{
            toast("Game Over")
        }


    }

    fun subtract(){

        var a = (0..100).random()
        var b = (0..100).random()

        sub = a - b

        subBinding.operand1.text = a.toString()
        subBinding.operand2.text = b.toString()


    }

    fun toast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}