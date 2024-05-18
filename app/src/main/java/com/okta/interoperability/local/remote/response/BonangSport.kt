package com.okta.interoperability.local.remote.response

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "BonangSport", strict = false)
data class BonangSport @JvmOverloads constructor(
    @field:ElementList(inline = true)
    var produk: List<Produk>? = null
)

@Root(name = "produk", strict = false)
data class Produk @JvmOverloads constructor(
    @field:Attribute(name = "id")
    var id: String? = null,

    @field:Element(name = "nama")
    var nama: String? = null,

    @field:Element(name = "deskripsi")
    var deskripsi: String? = null,

    @field:Element(name = "harga")
    var harga: String? = null,

    @field:Element(name = "gambar")
    var gambar: String? = null
)
