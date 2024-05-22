package com.example.debugbikeservice

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.debugbikeservice.databinding.ActivityMulBinding

class MulActivity : AppCompatActivity() {
    lateinit var  mulBinding: ActivityMulBinding

    var a : Int = (0 .. 100).random()
    var b : Int = (0 .. 100).random()

    var mul : Int  = a * b
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mulBinding = ActivityMulBinding.inflate(layoutInflater)
        setContentView(mulBinding.root)


        var life  : Int = 3
        var score : Int  = 0


        object  : CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {

                mulBinding.timer.text = (p0/1000).toString()
            }

            override fun onFinish() {

                life = life - 1 ;
                mulBinding.lifeSpan.text =life.toString()

                toast("Game OVer")


            }
        }

        if(life > 0) {
            mulBinding.checkButtonmul.setOnClickListener {
                val answer : Int = mulBinding.number.text.toString().toInt()

                if(answer ==  mul){
                    score = score + 10
                    multiplication()
                    toast("Correct answer")

                    mulBinding.number.text = score.toString()

                }
                else{
                    life = life - 1
                    mulBinding.lifeSpan.text = life.toString()
                    toast("Wrong answer")
                }


            }
        }



    }

    fun multiplication(){
        var a : Int = (0 .. 100).random()
        var b : Int = (0 .. 100).random()

        var mul : Int  = a * b
        mulBinding.operand1.text = a.toString()
        mulBinding.operand2.text = b.toString()

    }

    fun toast(message : String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
}