package com.kesha.configbuilder.confClass;

import org.junit.Assert;
import org.junit.Test;

public class SystemConfigTest{

    @Test
    public void getConfigTest() {
        System.out.println(SystemConfig.getIsOpenTest());
        Assert.assertEquals("true", SystemConfig.getIsOpenTest());

        System.out.println(SystemConfig.getName());
        Assert.assertEquals("nibilu", SystemConfig.getName());

        System.out.println(SystemConfig.getAddress());
        Assert.assertEquals("hangzhou", SystemConfig.getAddress());

    }

}