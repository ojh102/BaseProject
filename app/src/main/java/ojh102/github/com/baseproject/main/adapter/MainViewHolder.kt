package ojh102.github.com.baseproject.main.adapter

import android.os.Build
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import kotlinx.android.synthetic.main.search_item.view.*
import ojh102.github.com.baseproject.common.loadImage
import ojh102.github.com.baseproject.main.model.SearchItem

/**
 * Created by ohjaehwan on 2017. 1. 4..
 */
class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: SearchItem) {
        itemView.tvTitle.text = html2String(html2String(item.title))
        itemView.ivImage.loadImage(item.image)
    }

    fun html2String(str: String) = if (Build.VERSION.SDK_INT >= 24) {
        Html.fromHtml(str, Html.FROM_HTML_MODE_LEGACY).toString() // for 24 api and more
    } else {
        Html.fromHtml(str).toString() // or for older api
    }
}