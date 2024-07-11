package edu.quinnipiac.seoweek4

import android.util.Log
import androidx.test.core.app.ApplicationProvider
import com.google.firebase.firestore.FirebaseFirestore
import org.junit.Assert.*
import org.junit.Test
import kotlinx.coroutines.test.runTest

class UserDataTest {
    private val userData = UserData

    @Test
    fun testSetAndGetProgress() = runTest {
        userData.setProgress(ApplicationProvider.getApplicationContext(),1, 0.5)
        val progress = userData.getProgress(ApplicationProvider.getApplicationContext(),1)
        assertEquals(0.5, progress, 1e-15)
    }

}