package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent, 5);

        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify repeat is Days selected");

        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(), "Verify weekday is not selected");






    }
    @Test
    public void test2(){

        LoginPage loginPage= new LoginPage();

        loginPage.loginAsDriver();

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent, 5);
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        Select repeatsDropDown = createCalendarEventsPage.repeatOptionsList();

        List<String> expectedList = Arrays.asList("Daily", "Weekly","Monthly", "Yearly");

        List<WebElement> actualOptions = repeatsDropDown.getOptions();

        List<String> actualList = new ArrayList<>();


        for (WebElement Option : actualOptions) {
            actualList.add(Option.getText());
        }

        Assert.assertEquals(actualList, expectedList, "Verify Daily Weekly Monthly Yearly");





    }

}
