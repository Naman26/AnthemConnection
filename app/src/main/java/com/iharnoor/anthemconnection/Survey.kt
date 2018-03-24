package com.iharnoor.anthemconnection

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_survey.*

class Survey : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)
        selectedFace.visibility = View.INVISIBLE
        questionText.text = listQuestions[count++]


        skipOrNextBtn.setBackgroundColor(Color.GRAY)


        skipOrNextBtn.setOnClickListener {
            reset()
            if (count < 10)
                questionText.text = listQuestions[count++]
            else {
                Toast.makeText(this, "10 Questions completed", Toast.LENGTH_LONG).show()
                finish()
            }
        }
        closeBtn.setOnClickListener {
            finish()
        }
        agree.setOnClickListener {
            selectedFace.visibility = View.VISIBLE
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            selectedFace.setImageResource(R.drawable.slightly_smiling_face_emoji)
            skipOrNextBtn.setText("NEXT")

        }
        stronglyDisagree.setOnClickListener {
            selectedFace.visibility = View.VISIBLE
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            skipOrNextBtn.setText("NEXT")
            selectedFace.setImageResource(R.drawable.very_sad_emoji_icon_png)
        }
        stronglyAgree.setOnClickListener {
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            skipOrNextBtn.setText("NEXT")
            selectedFace.visibility = View.VISIBLE
            selectedFace.setImageResource(R.drawable.smiling_emoji_with_eyes_opened)
        }
        neutralFace.setOnClickListener {
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            skipOrNextBtn.setText("NEXT")
            selectedFace.visibility = View.VISIBLE
            selectedFace.setImageResource(R.drawable.neutral_face_emoji)
        }
        disagree.setOnClickListener {
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            skipOrNextBtn.setText("NEXT")
            selectedFace.visibility = View.VISIBLE
            selectedFace.setImageResource(R.drawable.confused_face_emoji)
        }
        selectedFace.setOnClickListener {
            selectedFace.visibility = View.INVISIBLE
            skipOrNextBtn.setBackgroundColor(Color.GRAY)
            skipOrNextBtn.setText("SKIP")
        }
    }

    fun reset(){
        selectedFace.visibility = View.INVISIBLE
        skipOrNextBtn.setBackgroundColor(Color.GRAY)
        skipOrNextBtn.setText("SKIP")
    }
}
