package com.sdetadda.allure;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Testcase1 {

    @Test
    public void TestMethod1() {

        Assert.assertTrue(false);
        System.out.println("TestMethod1 is not working as expected");
    }

}
