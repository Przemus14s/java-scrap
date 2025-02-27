package com.example.scrap_app.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SeleniumConfig {

    @Bean
    public WebDriver webDriver(){

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);

        return driver;
    }
}
