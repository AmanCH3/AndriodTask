package com.example.debugbikeservice

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Message
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.debugbikeservice.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    lateinit var addBinding: ActivityAddBinding

    var a : Int = (0..100).random()
    var b : Int = (0..100).random()

    var addition : Int = a + b
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        addBinding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(addBinding.root)

        var score : Int = 0
        var life : Int = 3


        object  : CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {

                addBinding.timer.text = (p0/1000).toString()
            }

            override fun onFinish() {

                life = life - 1 ;
                addBinding.lifeSpan.text =life.toString()

                toast("Game OVer")


            }

        }
        if(life > 0) {
            addBinding.checkButtonadd.setOnClickListener {

                var answer : Int = addBinding.number.text.toString().toInt()

                if(answer == addition){

                    score = score + 10
                    toast("Correct answer")
                    add()
                    addBinding.showScoreadd.text.toString()
                }

                else{
                    toast("Inccorect answer")
                    life = life - 1
                    addBinding.lifeSpan.text.toString()
                }

            }
        }



    }

    fun add(){
        var a : Int = (0 .. 100).random()
        var b : Int = (0 .. 100).random()

        var addition : Int  = a * b
        addBinding.operand1.text = a.toString()
        addBinding.operand2.text = b.toString()
    }

    fun toast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}