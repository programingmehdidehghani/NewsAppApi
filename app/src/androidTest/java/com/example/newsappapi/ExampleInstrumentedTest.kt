package com.example.newsappapi

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.newsappapi.ui.NewsActivity
import com.example.newsappapi.ui.fragments.BreakingNewsFragment
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {


    @Test
    fun useAppContext() {
        val scenario = ActivityScenario.launch(NewsActivity::class.java)
        onView(withId(R.id.rvBreakingNews))            // withId(R.id.my_view) is a ViewMatcher
            .check(matches(isDisplayed()));
        onView(withId(R.id.paginationProgressBar))
            .check(matches(isDisplayed()))
    }
}