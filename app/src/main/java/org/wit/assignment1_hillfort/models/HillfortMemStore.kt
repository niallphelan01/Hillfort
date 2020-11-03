package org.wit.assignment1_hillfort.models



import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info


var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class HillfortMemStore : HillfortStore, AnkoLogger {

    val hillforts = ArrayList<HillfortModel>()

    override fun findAll(): List<HillfortModel> {
        return hillforts
    }

    override fun create(hillfort: HillfortModel) {
        hillfort.id = getId()
        hillforts.add(hillfort)
        logAll()
    }

    override fun update(hillfort: HillfortModel) {
        var foundHillfort: HillfortModel? = hillforts.find { p -> p.id == hillfort.id }
        if (foundHillfort != null) {
            foundHillfort.name = hillfort.name
            foundHillfort.description = hillfort.description
            foundHillfort.image = hillfort.image
            foundHillfort.lat = hillfort.lat
            foundHillfort.lng = hillfort.lng
            foundHillfort.zoom = hillfort.zoom
            logAll();
        }
    }

    override fun findUsers(user_name: String?, password: String): Users? {
        TODO("Not yet implemented")
    }

    override fun createUsers(user: Users) {
        TODO("Not yet implemented")
    }

    fun logAll() {
        hillforts.forEach { info("${it}") }
    }
}