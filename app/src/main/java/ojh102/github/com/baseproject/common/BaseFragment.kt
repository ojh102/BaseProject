package ojh102.github.com.baseproject.common

import android.os.Bundle
import android.support.v4.app.Fragment
import ojh102.github.com.baseproject.common.MyApplication
import ojh102.github.com.baseproject.common.di.NetworkComponent

/**
 * Created by OhJaeHwan on 2017-01-03.
 */
abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setComponent((activity.application as MyApplication).getNetworkComponent())
    }

    protected abstract fun setComponent(networkComponent: NetworkComponent)
}
