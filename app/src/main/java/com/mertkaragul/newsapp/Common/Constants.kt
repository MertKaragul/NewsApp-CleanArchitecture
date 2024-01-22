package com.mertkaragul.newsapp.Common

object Constants {
    const val API_KEY = "566c0c3ee5dd4bd99ad037bfa99e157b"
    const val BASE_URL = "https://newsapi.org/"
    const val COUNTRY = "tr"


    // Categories
    val categories = mutableMapOf<String,String>().apply {
        put("health", "Sağlık")
        put("business", "İş")
        put("entertainment", "Eğlence")
        put("science", "Bilim")
        put("sports", "Spor")
        put("technology", "Teknoloji")
    }.toList()


}