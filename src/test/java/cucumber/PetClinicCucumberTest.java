package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = { "src/test/resources/features/petclinic"})
public class PetClinicCucumberTest extends AbstractTestNGCucumberTests{

}
