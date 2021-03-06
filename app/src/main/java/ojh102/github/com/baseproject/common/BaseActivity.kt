package ojh102.github.com.baseproject.common

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ojh102.github.com.baseproject.common.di.NetworkComponent

/**
 * Created by OhJaeHwan on 2017-01-03.
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setComponent((application as MyApplication).getNetworkComponent())
    }

    protected abstract fun setComponent(networkComponent: NetworkComponent)
}