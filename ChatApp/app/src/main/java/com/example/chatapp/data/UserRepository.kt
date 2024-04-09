package com.example.chatapp.data

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UserRepository(
    private val auth : FirebaseAuth,
    private val firestore: FirebaseFirestore
)
{
    suspend fun signUp(email : String, password : String, firstname : String, lastname : String) : Result<Boolean> =
        try{
            auth.createUserWithEmailAndPassword(email, password).await()
            val user = User(firstname, lastname, email)
            saveUserToFireStore(user)
            Result.Success(true)
        }
        catch(e : Exception){
            Result.Error(e)
        }

    private suspend fun saveUserToFireStore(user : User){
        firestore.collection("users").document(user.email).set(user).await()
    }

    suspend fun getCurrentUser(): kotlin.Result<User> = try {
        val uid = auth.currentUser?.email
        if (uid != null) {
            val userDocument = firestore.collection("users").document(uid).get().await()
            val user = userDocument.toObject(User::class.java)
            if (user != null) {
                Log.d("user2","$uid")
                kotlin.Result.Success(user)
            } else {
                kotlin.Result.Error(Exception("User data not found"))
            }
        } else {
            kotlin.Result.Error(Exception("User not authenticated"))
        }
    } catch (e: Exception) {
        kotlin.Result.Error(e)
    }

    suspend fun login(email: String, password: String): Result<Boolean> =
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            Result.Success(true)
        } catch (e: Exception) {
            Result.Error(e)
        }


}