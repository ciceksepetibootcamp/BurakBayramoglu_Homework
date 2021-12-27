package utils;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features ={"src/main/resources/Gratisbdd.feature"},
        glue = {"tests"}
        //tags = {"@positive"}
)

public class Executer {
}