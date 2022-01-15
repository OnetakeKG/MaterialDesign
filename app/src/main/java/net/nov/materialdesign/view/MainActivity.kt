package net.nov.materialdesign.view

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import net.nov.materialdesign.R
import net.nov.materialdesign.view.picture.PictureOfTheDayFragment
import smartdevelop.ir.eram.showcaseviewlib.GuideView
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity
import smartdevelop.ir.eram.showcaseviewlib.listener.GuideListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        // если во время исполнения то не забываем выполнить recreate()
        setTheme(R.style.Theme_MaterialDesign)
        setContentView(R.layout.activity_test_button)
        val builder = GuideView.Builder(this)
            .setTitle("Новая фича")
            .setContentText("Мы добавили эту новую функциональность, чтобы радовать вас дальше и больше")
            .setGravity(Gravity.center)
            .setDismissType(DismissType.selfView)
            .setTargetView(findViewById<Button>(R.id.btn_11))
            .setDismissType(DismissType.anywhere)
            .setGuideListener(object : GuideListener {
                override fun onDismiss(view: View?) {

                }
            })
        builder.build().show()

    }

    private fun isConnecton(): Boolean {
        return true
    }

}