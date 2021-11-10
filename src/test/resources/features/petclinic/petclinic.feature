Feature: PetClinic Operations

	Background: To launch the browser
			Given launch the browser
		
	Scenario: Search for Karaca in Petclinic
		When Hit Petclinic on the browser
		Then Enter "Karaca" in the search box
		Then Search it 
		Then Verify User