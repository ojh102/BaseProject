package ojh102.github.com.baseproject.common

import android.app.Application
import ojh102.github.com.baseproject.common.di.AppModule
import ojh102.github.com.baseproject.common.di.DaggerNetworkComponent
import ojh102.github.com.baseproject.common.di.NetworkComponent
import ojh102.github.com.baseproject.common.di.NetworkModule

/**
 * Created by OhJaeHwan on 2017-01-03.
 */
class MyApplication : Application() {

    private lateinit var networkComponent: NetworkComponent

    override fun onCreate() {
        super.onCreate()

        networkComponent = DaggerNetworkComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule()).build()
    }

    fun getNetworkComponent(): NetworkComponent = networkComponent
}