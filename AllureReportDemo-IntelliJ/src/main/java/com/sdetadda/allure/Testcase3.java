package com.sdetadda.allure;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Testcase3 {

    @Test
    public void TestMethod3() {
        throw new SkipException("TestMethod3 will be skipped");
    }

    @Test
    public void TestMethod4() {
        throw new SkipException("TestMethod4 will be skipped");
    }

}
