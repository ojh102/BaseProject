package ojh102.github.com.baseproject.main.di

import dagger.Component
import ojh102.github.com.baseproject.common.di.NetworkComponent
import ojh102.github.com.baseproject.common.di.PerActivity
import ojh102.github.com.baseproject.main.view.MainActivity

/**
 * Created by ohjaehwan on 2017. 1. 4..
 */
@PerActivity
@Component(dependencies = arrayOf(NetworkComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}