package com.arfapps.cesar_app.ui.view;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

	@Rule
	ActivityTestRule<MainActivity> mainAct = new ActivityTestRule<>(MainActivity.class, true, true);

	@Test
	public void onMainAct_showListItems() {
		onView(ViewMatchers.isRoot()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
	}
}