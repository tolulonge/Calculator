package com.tolulope.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   private var op = "*"
   private var isNewOp = true
   private var oldNumber =""
   private var finalNumber:Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvents(view: View) {
        if (isNewOp){
            screen.text = ""
        }
        isNewOp=false
        val buSelected = view as Button
        var buClicked =  screen.text.toString()
        when(buSelected.id){
            zero.id->{
                buClicked+="0"
            }
            one.id->{
                buClicked+="1"
            }
            two.id->{
                buClicked+="2"
            }
            three.id->{
                buClicked+="3"
            }
            four.id->{
                buClicked+="4"
            }
            five.id->{
                buClicked+="5"
            }
            six.id->{
                buClicked+="6"
            }
            seven.id->{
                buClicked+="7"
            }
            eight.id->{
                buClicked+="8"
            }
            nine.id->{
                buClicked+="9"
            }
            point.id->{
                //TODO: Make sure no more than one point
                buClicked+="."
            }
            plusOrMinus.id->{
                buClicked= "-$buClicked"
            }
        }
        screen.text = buClicked

    }


    fun buOperationEvent(view: View){
        val buSelected = view as Button
        when(buSelected.id){
            multiply.id->{
                op = "*"
            }
            divide.id->{
                op = "/"
            }
            add.id->{
                op = "+"
            }
            minus.id->{
                op = "-"
            }
            percent.id->{
                val number = screen.text.toString().toDouble()/100
                screen.text = number.toString()
                isNewOp = true
            }
        }
        isNewOp = true
        oldNumber = screen.text.toString()
    }

    fun buEqualEvent(view: View){
        val newNumber = screen.text.toString()

        when(op){
            "*"->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "+"->{
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-"->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "/"->{
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }

        }
        screen.text = finalNumber.toString()
        isNewOp=true
    }

    fun buCleanUp(view: View){
        screen.text = "0"
        isNewOp = true
        finalNumber = 0.0
    }
}