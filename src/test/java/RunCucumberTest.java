import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/report/report.json", 
        		"junit:target/report/report.xml"},
        features = {"src/test/resources/features"},
        glue = {"steps"},
        monochrome = true
)
public class RunCucumberTest {
}