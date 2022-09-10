package mx.uv.sbc.formappdemo;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith (AndroidJUnit4.class)
public class FormAppDemoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void PassingDataInterActivitiesTest () {
        //setup
        String name = "Gonzalo";
        String lastName = "Avendaño";
        String phone = "2291234567";

        //act
        onView (withId (R.id.edtName)).perform (typeText (name),
                ViewActions.closeSoftKeyboard ());

        onView (withId (R.id.edtLastname)).perform (replaceText (lastName),
                ViewActions.closeSoftKeyboard ());

        onView (withId (R.id.edtPhone)).perform (typeText (phone),
                ViewActions.closeSoftKeyboard ());

        onView (withId (R.id.btnSend)).perform (click ());

        //assert
        onView (withId (R.id.tvNameDetails)).check (matches (withText (name)));
        onView (withId (R.id.tvLastNameDetails)).check (matches (withText (lastName)));
        onView (withId (R.id.tvPhoneDetails)).check (matches (withText (phone)));
    }
}
