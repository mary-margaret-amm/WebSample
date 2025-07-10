<<<<<<<< HEAD:src/main/java/com/example/Pom/BaseClass.java
package com.example.Pom;

========
package com.example;
>>>>>>>> c192b0a614a1ab82b58c77f7fcb0ca8beceb80a2:src/main/java/com/example/BaseClass.java
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    public static WebDriver driver;

    public void browserLaunch() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        driver.quit();
    }
}
