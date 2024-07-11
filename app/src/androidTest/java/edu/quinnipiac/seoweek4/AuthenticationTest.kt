package edu.quinnipiac.seoweek4

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import org.junit.Assert.*
import org.junit.Test
import kotlinx.coroutines.test.runTest

class AuthenticationTest {

    private val authentication = Authentication()


    @Test
    fun testRegisterUser() = runTest {
        val result = authentication.registerUser("test@example.com", "testpassword")
        assertNotNull(result)
    }

    @Test
    fun testLoginUser() = runTest {
        val result = authentication.loginUser("test@example.com", "testpassword")
        assertNotNull(result)
    }

    @Test
    fun testUserLoggedIn() = runTest {
        authentication.loginUser("test@example.com", "testpassword")
        val result = authentication.userLoggedIn()
        assertTrue(result)
    }

    @Test
    fun testGetUserID() = runTest {
        authentication.loginUser("test@example.com", "testpassword")
        val userID = authentication.getUserID()
        assertNotNull(userID)
    }

}