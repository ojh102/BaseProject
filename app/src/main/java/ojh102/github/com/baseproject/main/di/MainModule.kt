package ojh102.github.com.baseproject.main.di

import dagger.Module
import dagger.Provides
import ojh102.github.com.baseproject.common.di.PerActivity
import ojh102.github.com.baseproject.main.adapter.MainAdapter
import ojh102.github.com.baseproject.main.adapter.MainAdapterModel
import ojh102.github.com.baseproject.main.adapter.MainAdapterView
import ojh102.github.com.baseproject.main.presenter.MainContract
import ojh102.github.com.baseproject.main.presenter.MainPresenter

/**
 * Created by ohjaehwan on 2017. 1. 4..
 */
@Module
class MainModule(
        val mainView: MainContract.View,
        val mainAdapter: MainAdapter
) {

    @PerActivity
    @Provides
    fun provideMainAdapterModel(): MainAdapterModel {
        return mainAdapter
    }

    @PerActivity
    @Provides
    fun provideMainAdapterView(): MainAdapterView {
        return mainAdapter
    }

    @PerActivity
    @Provides
    fun provideMainPresenter(mainPresenter: MainPresenter): MainContract.Presenter {
        return mainPresenter
    }

    @PerActivity
    @Provides
    fun provideMainView(): MainContract.View {
        return mainView
    }


}