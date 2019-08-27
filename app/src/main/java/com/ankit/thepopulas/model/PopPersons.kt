package com.ankit.thepopulas.model

data class PopPersons(
    val page: Int,
    val results: List<ResultX>,
    val total_pages: Int,
    val total_results: Int
)