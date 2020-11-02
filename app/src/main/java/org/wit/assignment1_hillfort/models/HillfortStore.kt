package org.wit.assignment1_hillfort.models

interface HillfortStore {
    fun findAll(): List<HillfortModel>
    fun create(hillfort: HillfortModel)
    fun update(hillfort: HillfortModel)
    fun findUsers(): List<Users>
    fun createUsers(user: Users)

}


