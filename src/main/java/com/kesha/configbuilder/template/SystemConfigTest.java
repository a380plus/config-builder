package com.kesha.configbuilder.template;

import org.junit.Assert;
import org.junit.Test;

public class SystemConfigTest {

    @Test
    public void getIsOpenTest() {
        System.out.println(SystemConfig.getIsOpenTest());
        Assert.assertEquals("true", SystemConfig.getIsOpenTest());
        Assert.assertEquals("true", SystemConfig.getIsOpenTest("aa"));
    }


}
