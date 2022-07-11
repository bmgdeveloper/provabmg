package com.picpay.desafio.android.feature.main


import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.picpay.desafio.android.R
import org.hamcrest.CoreMatchers.anything
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        onData(anything()).inAdapterView(withId(R.id.recyclerView)).atPosition(0).perform(click());
    }
}
