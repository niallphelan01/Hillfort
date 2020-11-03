package org.wit.assignment1_hillfort.models

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.assignment1_hillfort.helpers.*
import java.util.*

val JSON_FILE = "hillforts.json"
val JSON_USER_FILE = "users.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<HillfortModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class HillfortJSONStore : HillfortStore, AnkoLogger {

    val context: Context
    var hillforts = mutableListOf<HillfortModel>()
    var users = mutableListOf<Users>()

    constructor (context: Context) {
        this.context = context
        if (exists(context, JSON_FILE)) {
            deserialize()
        }
        if (exists(context, JSON_USER_FILE)) {
            deserializeUsers()
        }

    }

    override fun findAll(): MutableList<HillfortModel> {
        return hillforts
    }

    override fun create(hillfort: HillfortModel) {
        hillfort.id = generateRandomId()
        hillforts.add(hillfort)
        serialize()
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
            hillforts.forEach({hillfort})
            serialize()
        }

    }

    override fun findUsers(user_name: String?, password: String): Users? {
        info("Got here")
       val foundUser: Users? = users.find{ p -> p.email == user_name }

        info (foundUser)
        return foundUser
    }

    override fun createUsers(user: Users) {
        user.user_id= generateRandomId()
        users.add(user)
        serializeUsers()
    }

       private fun serialize() {
        val jsonString = gsonBuilder.toJson(hillforts, listType)
        write(context, JSON_FILE, jsonString)
    }
    private fun serializeUsers() {

        val jsonString = gsonBuilder.toJson(users, listType)
        write(context, JSON_USER_FILE, jsonString)
    }


    private fun deserialize() {
        val jsonString = read(context, JSON_FILE)
        hillforts= Gson().fromJson(jsonString, listType)
    }

    private fun deserializeUsers() {
        val jsonString = read(context, JSON_USER_FILE)
        users= Gson().fromJson(jsonString, listType)
    }
}


