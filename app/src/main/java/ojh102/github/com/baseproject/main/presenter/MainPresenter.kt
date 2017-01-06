package ojh102.github.com.baseproject.main.presenter

import ojh102.github.com.baseproject.common.APIService
import ojh102.github.com.baseproject.common.Define
import ojh102.github.com.baseproject.main.adapter.MainAdapterModel
import ojh102.github.com.baseproject.main.adapter.MainAdapterView
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by ohjaehwan on 2017. 1. 4..
 */
class MainPresenter @Inject constructor(
        val mainView: MainContract.View,
        val apiService: APIService,
        val mainAdapterModel: MainAdapterModel,
        val mainAdapterView: MainAdapterView
) : MainContract.Presenter {

    override fun searchImage(keyword: String, page: Int) {
        if(keyword.isNotEmpty()) {
            apiService.getImages(Define.KEY, keyword, page)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ res ->
                        mainAdapterModel.add(res.channel.item)
                        mainAdapterView.refreshAll()
                    }, { error ->
                        mainView.showToast(error.message.toString())
                    })
        } else {
            mainView.showToast("키워드를 입력해주세요.")
        }
    }

    override fun clear() {
        mainAdapterModel.clear()
    }
}