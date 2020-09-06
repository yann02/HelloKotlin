package com.example.hellokotlin.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilTest {
    private String time = "2017-10-15 16:00:02";

    private long timeStamp = 1508054402000L;

    private Date mDate;
    @Before
    public void setUp() throws Exception {
        System.out.println("测试开始！");
        mDate = new Date();
        mDate.setTime(timeStamp);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束！");
    }

    @Test
    public void stampToDate() {
        assertEquals("Hello Test.",time, DateUtil.stampToDate(timeStamp));
    }

    @Test
    public void dateToStamp() throws ParseException {
        assertEquals("dateToStamp",timeStamp,DateUtil.dateToStamp(time));
    }
}