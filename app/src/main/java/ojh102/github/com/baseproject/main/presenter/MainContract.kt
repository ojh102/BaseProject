package ojh102.github.com.baseproject.main.presenter

/**
 * Created by ohjaehwan on 2017. 1. 4..
 */
interface MainContract {
    interface Presenter {
        fun searchImage(keyword: String, page: Int)
        fun clear()
    }

    interface View {
        fun showToast(message: String)
    }
}