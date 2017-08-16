package com.example.android.teatime;

/**
 * Created by Yevgeniy on 8/16/2017.
 */

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.anything;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



//In this test we demo a user clicking a gridview item in MenuActivity, which opens
//up a corresponding OrderActivity.
@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {

    public static final String TEA_NAME = "Green Tea";

    /**
     * The ActivityTestRule is a rule provided by Android used for functional testing of a single
     * activity. The activity that will be tested will be launched before each test that's annotated
     * with @Test and before methods annotated with @Before. The activity will be terminated after
     * the test and methods annotated with @After are complete. This rule allows you to directly
     * access the activity during the test.
     */
    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule = new ActivityTestRule<>(MenuActivity.class);





    @Test
    public void clickGridViewItem_OpensOrderActivity() {

        //Since AdapterViews load data dynamically from an Adapter, only a subset of the contents
        //may be loaded in the current view heirarchy at a time. This means that onView() may not be able
        //to find the view you want. To handle this we use onData which loads the adapter item we are interested
        //in onto the screen before operating on it.

        //To help us further specify the item we are interested in, we use DataOption methods such as
        //inAdapterView and atPosition.

        //After which we perform an action on the item. Then we check that the Title textview contains
        //the name of item we clicked, in this case we clicked on the item
        // at position 1 which is GREEN TEA so it should be GREEN TEA.

        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(1).perform(click());
        onView(withId(R.id.tea_name_text_view)).check(matches(withText(TEA_NAME)));

    }

}
