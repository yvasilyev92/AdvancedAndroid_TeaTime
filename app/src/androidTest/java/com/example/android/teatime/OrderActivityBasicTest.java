package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Yevgeniy on 8/16/2017.
 */

//This line allows AndroidStudio know that I want to run this test with our AndroidJUnit4.
    //AndroidJUnit is a class that will let us control launching the app as well as running
    //the UI tests on it.
    //The "@" is from our support-annotations
@RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest {

    //We begin with an ActivityTestRule using the @Rule annotation.
    //ActivityTestRule is a rule that provides functional testing for a specific single Activity.
    //We're focused on the OrderActivity so we add it between the brackets.
    @Rule
    public ActivityTestRule<OrderActivity> mActivityTestRule = new ActivityTestRule<>(OrderActivity.class);

    //Now we right the actual test. We start with the @Test annotation which indicates that this is where
    //we'll be testing what we're interested in. When choosing a test name, choose one that clearly indicates
    //the purpose of the test.
    @Test
    public void clickIncrementButton_ChangesQuantityAndCost(){
        //1) Find the view
        //2) Perform action on the view
        onView(withId(R.id.increment_button)).perform(click());

        //3) Check if the view does what you expected.
        //We check that clicking the increment button sets the price to $5.00 and sets quantity to 1.
        onView(withId(R.id.quantity_text_view)).check(matches(withText("1")));
        onView(withId(R.id.cost_text_view)).check(matches(withText("$5.00")));
    }


    //Test what happens when the Decrement button is clicked.
    @Test
    public void clickDecrementButton_ChangesQuantityAndCost() {

        // Check the initial quantity variable is zero
        onView((withId(R.id.quantity_text_view))).check(matches(withText("0")));

        // Click on decrement button
        onView((withId(R.id.decrement_button)))
                .perform(click());

        // Verify that the decrement button decreases the quantity by 1
        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));

        // Verify that the increment button also increases the total cost to $5.00
        onView(withId(R.id.cost_text_view)).check(matches(withText("$0.00")));

    }


}
