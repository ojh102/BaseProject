package ojh102.github.com.baseproject.main.adapter

import ojh102.github.com.baseproject.main.model.SearchItem

/**
 * Created by ohjaehwan on 2017. 1. 4..
 */
interface MainAdapterModel {
    fun add(items: List<SearchItem>)
    fun add(item: SearchItem)
    fun clear()
}