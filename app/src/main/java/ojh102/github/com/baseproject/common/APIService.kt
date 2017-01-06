package ojh102.github.com.baseproject.common

import io.reactivex.Flowable
import ojh102.github.com.baseproject.main.model.ResSearch
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by OhJaeHwan on 2017-01-03.
 */
interface APIService {
    @GET("search/image")
    fun getImages(
            @Query("apikey") apikey: String ,
            @Query("q") query: String,
            @Query("pageno") pageno: Int,
            @Query("result") result: Int = 10,
            @Query("output") output: String = Define.FORMAT
    ): Flowable<ResSearch>
}