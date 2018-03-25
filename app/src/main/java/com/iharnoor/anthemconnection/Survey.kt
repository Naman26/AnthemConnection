package com.iharnoor.anthemconnection

import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_survey.*

class Survey : AppCompatActivity() {
    var isGray = arrayListOf<Boolean>(false, false, false, false, false)

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
                streaks++
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
            agree.colorFilter = turnGray()

            disagree.colorFilter = resetGray()
            stronglyDisagree.colorFilter = resetGray()
            stronglyAgree.colorFilter = resetGray()
            neutralFace.colorFilter = resetGray()
        }
        stronglyDisagree.setOnClickListener {
            selectedFace.visibility = View.VISIBLE
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            skipOrNextBtn.setText("NEXT")
            selectedFace.setImageResource(R.drawable.very_sad_emoji_icon_png)
            stronglyDisagree.colorFilter = turnGray()

            disagree.colorFilter = resetGray()
            agree.colorFilter = resetGray()
            stronglyAgree.colorFilter = resetGray()
            neutralFace.colorFilter = resetGray()
        }
        stronglyAgree.setOnClickListener {
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            skipOrNextBtn.setText("NEXT")
            selectedFace.visibility = View.VISIBLE
            selectedFace.setImageResource(R.drawable.smiling_emoji_with_eyes_opened)
            stronglyAgree.colorFilter = turnGray()

            disagree.colorFilter = resetGray()
            agree.colorFilter = resetGray()
            stronglyDisagree.colorFilter = resetGray()
            neutralFace.colorFilter = resetGray()
        }
        neutralFace.setOnClickListener {
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            skipOrNextBtn.setText("NEXT")
            selectedFace.visibility = View.VISIBLE
            selectedFace.setImageResource(R.drawable.neutral_face_emoji)
            neutralFace.colorFilter = turnGray()

            disagree.colorFilter = resetGray()
            agree.colorFilter = resetGray()
            stronglyDisagree.colorFilter = resetGray()
            stronglyAgree.colorFilter = resetGray()
        }
        disagree.setOnClickListener {
            skipOrNextBtn.setBackgroundColor(Color.parseColor("#2196F3"))
            skipOrNextBtn.setText("NEXT")
            selectedFace.visibility = View.VISIBLE
            selectedFace.setImageResource(R.drawable.confused_face_emoji)
            disagree.colorFilter = turnGray()

            agree.colorFilter = resetGray()
            stronglyDisagree.colorFilter = resetGray()
            stronglyAgree.colorFilter = resetGray()
            neutralFace.colorFilter = resetGray()
        }
        selectedFace.setOnClickListener {
            resetAllGray()
            selectedFace.visibility = View.INVISIBLE
            skipOrNextBtn.setBackgroundColor(Color.GRAY)
            skipOrNextBtn.setText("SKIP")
//            selectedFace.colorFilter = turnGray()
        }
    }

    fun resetGray(): ColorMatrixColorFilter {
        val matrix = ColorMatrix()
        matrix.setSaturation(1f)
        val filter = ColorMatrixColorFilter(matrix)
        return filter
    }

    fun turnGray(): ColorMatrixColorFilter {
        val matrix = ColorMatrix()
        matrix.setSaturation(0f)
        val filter = ColorMatrixColorFilter(matrix)
        return filter
    }


    fun reset() {
        disagree.colorFilter = resetGray()
        agree.colorFilter = resetGray()
        stronglyDisagree.colorFilter = resetGray()
        stronglyAgree.colorFilter = resetGray()
        neutralFace.colorFilter = resetGray()
        selectedFace.visibility = View.INVISIBLE
        skipOrNextBtn.setBackgroundColor(Color.GRAY)
        skipOrNextBtn.setText("SKIP")
    }

    fun resetAllGray() {
        disagree.colorFilter = resetGray()
        agree.colorFilter = resetGray()
        stronglyDisagree.colorFilter = resetGray()
        stronglyAgree.colorFilter = resetGray()
        neutralFace.colorFilter = resetGray()
    }
}
