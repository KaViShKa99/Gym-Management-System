package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void dateCheck() {
        Date date = new Date("12/02/2019");//created the date object from date class
        assertTrue(date.dateCheck("12/04/2019"));//normal date,test result true
        assertFalse(date.dateCheck("29/02/2019"));//leap year date,test result false
        assertFalse(date.dateCheck("String"));//input name ,test result false
        assertFalse(date.dateCheck("1234"));//input number ,test result false

    }
}