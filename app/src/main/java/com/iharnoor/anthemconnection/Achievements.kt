package com.iharnoor.anthemconnection

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_achievements.*
import android.graphics.ColorMatrixColorFilter
import android.graphics.ColorMatrix



class Achievements : AppCompatActivity() {
    var survey = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_achievements)

        val matrix = ColorMatrix()
        matrix.setSaturation(0f)
        val filter = ColorMatrixColorFilter(matrix)

        val matrix2 = ColorMatrix()
        matrix2.setSaturation(1f)
        val unfilter = ColorMatrixColorFilter(matrix2)

        survey1.setColorFilter(filter)
        survey5.setColorFilter(filter)
        survey10.setColorFilter(filter)
        streak3.setColorFilter(filter)
        streak5.setColorFilter(filter)
        streak10.setColorFilter(filter)
        streak20.setColorFilter(filter)
        allemojis.setColorFilter(filter)
        friendship.setColorFilter(filter)
        redeeming.setColorFilter(filter)
        leaderboardvisit.setColorFilter(filter)
        leaderboardon.setColorFilter(filter)

    }
}
