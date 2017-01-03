package ojh102.github.com.baseproject.common.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by OhJaeHwan on 2017-01-03.
 */
@Module
class AppModule(val application: Application) {

    @Singleton
    @Provides
    fun provideApplication() = application
}