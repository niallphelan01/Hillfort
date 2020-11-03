package org.wit.assignment1_hillfort.activities


import android.content.Intent
import android.os.Bundle
import android.os.Handler


import androidx.appcompat.app.AppCompatActivity
import org.wit.assignment1_hillfort.main.MainApp


class SplashActivity : AppCompatActivity() {

   private val SPLASH_TIME_OUT:Long=3000 // 3 sec
   override fun onCreate(savedInstanceState: Bundle?) {
        super .onCreate(savedInstanceState)
       Handler().postDelayed({
      // startActivity(Intent(this,HillfortListActivity::class.java))
         startActivity(Intent(this,LoginActivity::class.java))
           finish()
       }, SPLASH_TIME_OUT)
   }
}




