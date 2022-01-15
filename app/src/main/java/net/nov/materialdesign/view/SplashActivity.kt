package net.nov.materialdesign.view

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

import net.nov.materialdesign.R
import net.nov.materialdesign.view.picture.PictureOfTheDayFragment

@SuppressLint("CustomSplashScreen") //FIXME что ты такое
class SplashActivity : AppCompatActivity() {
    private val handler:Handler by lazy {
        Handler(mainLooper)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        /*findViewById<ImageView>(R.id.imageView).animate().rotationBy(720f).setInterpolator(
            LinearInterpolator()
        ).duration = 3000*/

        val animator = ObjectAnimator.ofFloat(findViewById<ImageView>(R.id.imageView), View.SCALE_Y,-1f);
        animator.duration = 500
        animator.repeatCount = 5
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()

        handler.postDelayed(Runnable {
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            finish()
        },2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}