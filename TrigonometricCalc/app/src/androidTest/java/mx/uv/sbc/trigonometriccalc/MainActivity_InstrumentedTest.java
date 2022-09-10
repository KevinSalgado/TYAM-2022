package mx.uv.sbc.trigonometriccalc;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivity_InstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void sin_function_test () {
        String sin45Result = "0.8509035245341184";

        onView (withId (R.id.rbSIN)).perform (click ());
        onView (withId (R.id.rb45)).perform (click ());
        onView (withId (R.id.tvResultados)).perform (scrollTo ());

        onView (withId (R.id.tvResultados)).check (matches (withText (sin45Result)));
        onView (withId (R.id.ivGrados)).check (matches (isDisplayed ()));
    }

    @Test
    public void cos_function_test () {
        String cos90Result = "-0.4480736161291701";

        onView (withId (R.id.rbCOS)).perform (click ());
        onView (withId (R.id.rb90)).perform (click ());
        onView (withId (R.id.tvResultados)).perform (scrollTo ());

        onView (withId (R.id.tvResultados)).check (matches (withText (cos90Result)));
        onView (withId (R.id.ivGrados)).check (matches (isDisplayed ()));
    }

    @Test
    public void tan_function_test () {
        String tan180Result = "1.3386902103511544";

        onView (withId (R.id.rbTAN)).perform (click ());
        onView (withId (R.id.rb180)).perform (click ());
        onView (withId (R.id.tvResultados)).perform (scrollTo ());

        onView (withId (R.id.tvResultados)).check (matches (withText (tan180Result)));
        onView (withId (R.id.ivGrados)).check (matches (isDisplayed ()));
    }

}