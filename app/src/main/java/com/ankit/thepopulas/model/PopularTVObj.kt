package com.ankit.thepopulas.model

data class PopularTVObj(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)