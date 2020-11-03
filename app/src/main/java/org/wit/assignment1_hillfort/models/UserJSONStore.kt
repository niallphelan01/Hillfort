package org.wit.assignment1_hillfort.models



import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.assignment1_hillfort.helpers.*
import java.util.*

val JSON_USER_FILE = "users.json"

val gsonBuilderUser = GsonBuilder().setPrettyPrinting().create()
val listUser = object : TypeToken<java.util.ArrayList<UsersModel>>() {}.type


fun generateRandomIdUser(): Long {
  return Random().nextLong()
}

 class UserJSONStore : UserStore, AnkoLogger {

  val context: Context
  var users = mutableListOf<UsersModel>()

  constructor (context: Context) {
    this.context = context
    if (exists(context, JSON_USER_FILE)) {
      deserialize()
    }
     }
  private fun deserialize() {
    val jsonString = read(context, JSON_USER_FILE)
    users= Gson().fromJson(jsonString, listUser)
  }
   private fun serialize() {
     val jsonString = gsonBuilderUser.toJson(users, listUser)
     write(context, JSON_USER_FILE, jsonString)
   }

   override fun findUsers(user: UsersModel): UsersModel? {
     info("Starting here")
     info(user.email)
     var foundUser: UsersModel? = users.find { p -> p.email == user.email }
     info(foundUser)

     if (foundUser != null) {
       if (foundUser.password == user.password) //check for password
       {
         info("passwords match")
       }
       else{
         info("password mismatch")
         return null
       }

     }
       //val foundUser: UsersModel? = users.find{ p -> p.email == user_name }
       //  val foundUser: List<UsersModel> = users.filter{users -> users == user_name}
       return foundUser

   }

   override fun createUsers(user: UsersModel) {
     user.user_id = generateRandomId()
     users.add(user)
     serialize()
   }

   override fun findAll(): MutableList<UsersModel> {
     info(users)
     return users
   }
 }
