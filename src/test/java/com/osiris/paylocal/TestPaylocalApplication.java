package com.osiris.paylocal;

import org.springframework.boot.SpringApplication;

public class TestPaylocalApplication {

    public static void main(String[] args) {
        SpringApplication.from(PaylocalApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
