package edu.quinnipiac.seoweek4

import org.junit.Assert.*
import org.junit.Test
import kotlinx.coroutines.test.runTest

class AuthenticationTest {

    private val authentication = Authentication()

    @Test
    fun testRegisterUser() {
        // Call registerUser with test data
        val result = runTest { authentication.registerUser("test@example.com", "testpassword") }

        // Assert the expected result (e.g., check if user object is not null)
        assertNotNull(result)
    }

    @Test
    fun testLoginUser() {
        var result = runTest { authentication.loginUser("test@example.com", "testpassword") }

    }

    // Similarly, write a test for loginUser
}