package org.wit.assignment1_hillfort.models

interface UserStore {
  fun findUsers(user: UsersModel): UsersModel?
  fun createUsers(user: UsersModel)
  fun findAll(): List<UsersModel>
}