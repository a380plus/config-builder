package com.kesha.configbuilder.confClass;

import org.junit.Assert;
import org.junit.Test;

public class InitConfigTest{

    @Test
    public void getConfigTest() {
        System.out.println(InitConfig.getMainClass());
        Assert.assertEquals("config-builder", InitConfig.getMainClass());

    }

}