package com.StepDefinition;
import com.example.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass extends BaseClass {

@Before
public void setup(){
browserLaunch();
}

@After
    public void tearDown() {
    closeBrowser();
    }
}
