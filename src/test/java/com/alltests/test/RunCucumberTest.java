package com.alltests.test;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/manheim.feature",plugin = {"pretty", "html:target/cucumber"})
public class RunCucumberTest {

}
