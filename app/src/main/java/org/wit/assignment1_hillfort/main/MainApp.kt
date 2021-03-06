package org.wit.assignment1_hillfort.main


import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.assignment1_hillfort.models.HillfortJSONStore
import org.wit.assignment1_hillfort.models.HillfortStore
import org.wit.assignment1_hillfort.models.UserJSONStore
import org.wit.assignment1_hillfort.models.UserStore


class MainApp : Application(), AnkoLogger {

    lateinit var hillforts : HillfortStore
    lateinit var users : UserStore
    //val hillforts = ArrayList<HillfortModel>()

    override fun onCreate() {
        super.onCreate()
            //hillforts = HillfortMemStore()
        hillforts = HillfortJSONStore(applicationContext)
       users = UserJSONStore(applicationContext)
       info("Hillfort started")
    }
}