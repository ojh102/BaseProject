package ojh102.github.com.baseproject.common.di

import android.app.Application
import dagger.Component
import ojh102.github.com.baseproject.common.APIService
import javax.inject.Singleton

/**
 * Created by OhJaeHwan on 2017-01-03.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface NetworkComponent {
    fun application(): Application
    fun apiService(): APIService
}