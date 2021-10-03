package es.iesnervion.mcasado.justpeople

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Rule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class BottomNavigationTest {

    @Rule
    @JvmField
    val rule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_bottom_navigation() {

        // Navigate to remove user
        onView(withId(R.id.remove_person)).perform(click())

        // Verify
        onView(withId(R.id.remove_person_fragment_root)).check(matches(isDisplayed()))
        onView(withId(R.id.add_person_fragment_root)).check(doesNotExist())
        onView(withId(R.id.persons_list_fragment_root)).check(doesNotExist())

        // Navigate to add user
        onView(withId(R.id.add_person)).perform(click())

        // Verify
        onView(withId(R.id.add_person_fragment_root)).check(matches(isDisplayed()))
        onView(withId(R.id.remove_person_fragment_root)).check(doesNotExist())
        onView(withId(R.id.persons_list_fragment_root)).check(doesNotExist())

        // Navigate to users list
        onView(withId(R.id.item_people_list)).perform(click())

        // Verify
        onView(withId(R.id.persons_list_fragment_root)).check(matches(isDisplayed()))
        onView(withId(R.id.add_person_fragment_root)).check(doesNotExist())
        onView(withId(R.id.remove_person_fragment_root)).check(doesNotExist())

    }

}