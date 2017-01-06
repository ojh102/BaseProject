package ojh102.github.com.baseproject.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ojh102.github.com.baseproject.R
import ojh102.github.com.baseproject.main.model.SearchItem
import java.util.*

/**
 * Created by ohjaehwan on 2017. 1. 4..
 */
class MainAdapter : RecyclerView.Adapter<MainViewHolder>(), MainAdapterModel, MainAdapterView {

    val searchItems by lazy { ArrayList<SearchItem>() }

    override fun getItemCount(): Int {
        return searchItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.search_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        holder?.bind(searchItems[position])
    }


    override fun add(items: List<SearchItem>) {
        searchItems.addAll(items)
    }

    override fun add(item: SearchItem) {
        searchItems.add(item)
    }

    override fun clear() {
        searchItems.clear()
    }

    override fun refreshAll() {
        notifyDataSetChanged()
    }

}