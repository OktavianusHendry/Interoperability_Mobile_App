package com.okta.interoperability.local.remote.retrofit

import com.okta.interoperability.local.remote.response.BonangSport
import com.okta.interoperability.local.remote.response.Produk
import com.okta.interoperability.local.remote.response.ProdukResponse
import com.okta.interoperability.local.remote.response.ProdukResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("getdata.php")
    fun getAllData(): Call<List<ProdukResponseItem>>

    @GET("produk.xml")
    fun getAllDataXML(): Call<BonangSport>
}
