package ojh102.github.com.baseproject.main.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ojh102.github.com.baseproject.common.APIService
import ojh102.github.com.baseproject.common.Define
import ojh102.github.com.baseproject.main.adapter.MainAdapterModel
import ojh102.github.com.baseproject.main.adapter.MainAdapterView
import javax.inject.Inject

/**
 * Created by ohjaehwan on 2017. 1. 4..
 */
class MainPresenter @Inject constructor(
        private val mainView: MainContract.View,
        private val apiService: APIService,
        private val mainAdapterModel: MainAdapterModel,
        private val mainAdapterView: MainAdapterView
) : MainContract.Presenter {

    override fun searchImage(keyword: String, page: Int) {
        if (keyword.isNotEmpty()) {
            apiService.getImages(Define.KEY, keyword, page)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnComplete { mainAdapterView.refreshAll() }
                    .subscribe(
                            { res -> mainAdapterModel.add(res.channel.item) },
                            { error -> mainView.showToast(error.message.toString()) }
                    )
        } else {
            mainView.showToast("키워드를 입력해주세요.")
        }
    }

    override fun clear() {
        mainAdapterModel.clear()
    }
}