package org.wit.assignment1_hillfort.main


import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.assignment1_hillfort.models.*

class MainApp : Application(), AnkoLogger {

    lateinit var hillforts : HillfortStore
    lateinit var users : HillfortStore
    //val hillforts = ArrayList<HillfortModel>()

    override fun onCreate() {
        super.onCreate()
            //hillforts = HillfortMemStore()
        hillforts = HillfortJSONStore(applicationContext)
        users = HillfortJSONStore(applicationContext)
       info("Hillfort started")
    }
}