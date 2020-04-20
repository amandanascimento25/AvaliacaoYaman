package runner.com;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		plugin = {"pretty", "html:target/HtmlReport", "json:target/JsonReport/json.json"},
		glue = {""},
		tags = {"@CadastroOportunidades, @ConsultaOportunidades"}
		)
public class TestRunner {

}
