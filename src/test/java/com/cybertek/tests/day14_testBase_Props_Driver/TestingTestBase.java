package com.cybertek.tests.day14_testBase_Props_Driver;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingTestBase extends TestBase {
    @Test
    public void testTitle(){
          String url = ConfigurationReader.getProperty("url");
          driver.get(url);

          Assert.assertEquals(driver.getTitle(), "Practice");
          String browser = ConfigurationReader.getProperty("browser");

      }
}
