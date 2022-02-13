package com.test;

import com.config.FrameworkConfig;
import org.aeonbits.owner.ConfigFactory;

public class Runner {

    public static void main(String[] args) {
        FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
        System.out.println(config.browser());
        System.out.println(config.username());
        System.out.println(config.url());
    }


}
