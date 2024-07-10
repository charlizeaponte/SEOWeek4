package edu.quinnipiac.seoweek4

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import com.google.firebase.auth.AuthResult

class Authentication {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun registerUser(email: String, password: String): FirebaseUser? {
        return try{
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            authResult.user
        } catch (e: Exception) {
            // Handle registration errors (e.g., email already in use)
            Log.d("register failed", "${e.message}")
            null
        }
    }

    suspend fun loginUser(email: String, password: String): FirebaseUser? {
        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            authResult.user
        } catch (e: Exception) {
            // Handle login errors (e.g., invalid credentials)
            Log.d("login failed", "${e.message}")
            null
        }
    }

    suspend fun userLoggedIn(): Boolean {
        val currentUser = firebaseAuth.currentUser
        return currentUser != null
    }

}