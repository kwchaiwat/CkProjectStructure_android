package com.example.ckprojectstructure_android.presentation.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.ckprojectstructure_android.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_isActivityInView() {
        onView(withId(R.id.title_page_main)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_covid)).check(matches(isDisplayed()))
    }

    @Test
    fun test_clickToCovidActivity() {
        onView(withId(R.id.btn_covid)).perform(click())
        onView(withId(R.id.btn_runstop)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_runstop)).perform(click())
    }

}