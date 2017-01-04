package ojh102.github.com.baseproject.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ojh102.github.com.baseproject.R
import ojh102.github.com.baseproject.main.view.MainActivity
import rx.Observable
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Observable.timer(3, TimeUnit.SECONDS).subscribe {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
