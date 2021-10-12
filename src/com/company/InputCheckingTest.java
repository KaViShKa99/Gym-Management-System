package com.company;

import static org.junit.jupiter.api.Assertions.*;

class InputCheckingTest {

    @org.junit.jupiter.api.Test
    void integerInputCheck() {
        assertTrue(InputChecking.testIntegerInput("0001"));//input number,test result true
        assertTrue(InputChecking.testIntegerInput("w0001"));//input we1,test result true
        assertFalse(InputChecking.testIntegerInput("String"));//input name,test result false
    }
    @org.junit.jupiter.api.Test
    void stringInputCheck() {
        assertTrue(InputChecking.nameCheck("kavishka")); //input simple letter name,test result true
        assertTrue(InputChecking.nameCheck("KAVISHKA"));//input capital letter name,test result true
        assertTrue(InputChecking.nameCheck(" "));// input space,result true
        assertFalse(InputChecking.nameCheck("!@#$%^&*()_+~.,?/"));//input another operator,test result false
        assertFalse(InputChecking.nameCheck("23"));//input integer type number,test result false

    }

    @org.junit.jupiter.api.Test
    void idCheck() {
        assertTrue(InputChecking.testDuplicateMembershipNumber("001", "001"));//if first member membershipNumber and second member membershipNumber are equal,duplicate membership number remove,test result true
        assertFalse(InputChecking.testDuplicateMembershipNumber("002", "001"));//if first and second member membership number are not equal,return newMembershipNumber,test result false
    }
}