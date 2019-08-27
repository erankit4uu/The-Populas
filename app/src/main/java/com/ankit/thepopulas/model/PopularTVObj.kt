package com.ankit.thepopulas.model


data class PopularTVObj(
    var page: Int = 0,
    var results: List<Result>,
    var total_pages: Int = 0,
    var total_results: Int = 0,
    var id : Int = 0
)