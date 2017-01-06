package ojh102.github.com.baseproject.main.view

import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ojh102.github.com.baseproject.R
import ojh102.github.com.baseproject.common.BaseActivity
import ojh102.github.com.baseproject.common.EndlessRecyclerViewScrollListener
import ojh102.github.com.baseproject.common.di.NetworkComponent
import ojh102.github.com.baseproject.common.toast
import ojh102.github.com.baseproject.main.adapter.MainAdapter
import ojh102.github.com.baseproject.main.di.DaggerMainComponent
import ojh102.github.com.baseproject.main.di.MainModule
import ojh102.github.com.baseproject.main.presenter.MainContract
import javax.inject.Inject


class MainActivity : BaseActivity(), MainContract.View {

    val mAdapter by lazy { MainAdapter() }
    @Inject lateinit var mainPresenter: MainContract.Presenter

    lateinit var mScrollListener: EndlessRecyclerViewScrollListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvSearch.layoutManager = layoutManager
        rvSearch.adapter = mAdapter

        mScrollListener = object : EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                mainPresenter.searchImage(editSearch.text.toString(), page)
            }
        }
        rvSearch.addOnScrollListener(mScrollListener)


        fbSearch.setOnClickListener {
            mScrollListener.resetState()
            mainPresenter.clear()
            mainPresenter.searchImage(editSearch.text.toString(), 1)
        }

    }

    override fun setComponent(networkComponent: NetworkComponent) {
        DaggerMainComponent.builder()
                .networkComponent(networkComponent)
                .mainModule(MainModule(this, mAdapter))
                .build()
                .inject(this)
    }

    override fun showToast(message: String) {
        toast(message)
    }
}
