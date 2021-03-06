/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.siscultural.system_tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
@Ignore
public class CompleteLoginAndTryBackAndDoLoginAgain {
    
    @Test
    public void CompleteLoginAndTryBackAndDoLoginAgain() {

        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8080/");

        driver.findElement(By.name("email")).sendKeys("victor.hugo.origins@gmail.com");
        driver.findElement(By.name("password")).sendKeys("abacaxi");
        new WebDriverWait(driver, 500) {};
        driver.findElement(By.id("input-login")).click();
        new WebDriverWait(driver, 500) {};
        new WebDriverWait(driver, 500) {};
        driver.navigate().to("http://localhost:8080/");

        Assert.assertEquals("http://localhost:8080/home", driver.getCurrentUrl());

        driver.close();

    }
    
}
