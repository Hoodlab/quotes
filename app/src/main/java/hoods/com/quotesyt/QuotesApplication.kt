package hoods.com.quotesyt

import android.app.Application

class QuotesApplication : Application() {
    override fun onCreate() {
        Graph.provide(this)
        super.onCreate()
    }
}