package pk_TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		//features = {"Feature/Retrieve_Country.feature"}
		//features = { "Feature/Get_Default_Country.feature" }
		//features = {"Feature/Create_Token.feature"}
		//features = {"Feature/Retrieve_Country_Multiple_Data.feature"}
		//features = {"Feature/Create_Address_Using_Token.feature"}
		features = {"Feature"}
		, glue = "pk_StepDefinition", dryRun = false, monochrome = true, plugin = { "pretty",
				"html:CucumberReport/Report.html" }
// ,plugin =
// {"pretty","html:CucumberReport/Report.html","rerun:Rerun/failed_scenarios.txt"}
// Execute all of them Except Sanity
// ,tags="not @smoke"
// Execute Smoke and Sanity both test cases
// ,tags= "@smoke or @sanity"
// Execute Smoke and Sanity , but both should be marked together in feature
// ,tags= "@smoke and @sanity"
,tags= "@smoke"

)

public class TestRunner_RestAssuredAPI {

}
