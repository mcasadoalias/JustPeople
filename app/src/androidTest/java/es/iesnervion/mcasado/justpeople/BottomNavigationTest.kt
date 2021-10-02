package es.iesnervion.mcasado.justpeople

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.NavigatorProvider
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Rule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.hamcrest.Matchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class BottomNavigationTest {

    @Rule
    @JvmField
    val rule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_bottom_navigation() {

        // Navigate to remove user
        onView(withId(R.id.remove_user)).perform(click())

        // Verify
        onView(withId(R.id.remove_user_fragment_root)).check(matches(isDisplayed()))
        onView(withId(R.id.add_user_fragment_root)).check(doesNotExist())
        onView(withId(R.id.users_list_fragment_root)).check(doesNotExist())

        // Navigate to add user
        onView(withId(R.id.add_user)).perform(click())

        // Verify
        onView(withId(R.id.add_user_fragment_root)).check(matches(isDisplayed()))
        onView(withId(R.id.remove_user_fragment_root)).check(doesNotExist())
        onView(withId(R.id.users_list_fragment_root)).check(doesNotExist())

        // Navigate to users list
        onView(withId(R.id.users_list)).perform(click())

        // Verify
        onView(withId(R.id.users_list_fragment_root)).check(matches(isDisplayed()))
        onView(withId(R.id.add_user_fragment_root)).check(doesNotExist())
        onView(withId(R.id.remove_user_fragment_root)).check(doesNotExist())

    }

}