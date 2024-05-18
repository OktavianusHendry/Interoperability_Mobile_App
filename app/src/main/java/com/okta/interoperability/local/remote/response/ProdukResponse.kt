package com.okta.interoperability.local.remote.response

import com.google.gson.annotations.SerializedName

data class ProdukResponse(

	@field:SerializedName("ProdukResponse")
	val produkResponse: List<ProdukResponseItem?>? = null
)

data class ProdukResponseItem(

	@field:SerializedName("seller")
	val seller: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("harga")
	val harga: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("brand")
	val brand: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null
)
