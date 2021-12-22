package net.nov.materialdesign.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.nov.materialdesign.R
import net.nov.materialdesign.view.picture.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance()).commit()

        }

    }

    private fun isConnecton(): Boolean {
        return true
    }

}