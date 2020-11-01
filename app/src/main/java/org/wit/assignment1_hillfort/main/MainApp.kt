package org.wit.assignment1_hillfort.main


import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

import org.wit.assignment1_hillfort.models.HillfortMemStore
import org.wit.assignment1_hillfort.models.HillfortModel
import org.wit.assignment1_hillfort.models.HillfortStore

class MainApp : Application(), AnkoLogger {

    lateinit var hillforts : HillfortStore
    //val hillforts = ArrayList<HillfortModel>()

    override fun onCreate() {
        super.onCreate()
        hillforts = HillfortMemStore()
       info("Hillfort started")
    }
}