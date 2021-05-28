Feature: login to the service-now Application

Background:
	Given Load URL
	When Move to frame
	And Type username 'admin'
	And Type password 'India@123'
	And click on Login button

	
	Scenario: create New Incident

	And search the Incident in filter
	And create New Incident
	And Get the Incident Number
	And click Caller lookup Button
	And Select the system_Administrator
	And Give the short_description 'Automation Testing Basics'
	And click Submit Button
	And Incident search in the Field
	Then Verify first match
	

	Scenario: Update Incident

	And search the Incident in filter1
	And Update Incident1
	And Incident search in the Field1
	And Select the first match1
	And Update the incident urgency1
	And WebElement incident state1
	And click Update Button1
	Then Verify first match1
	
	
	
	Scenario: Assign_the_incident

	And search the Incident in filter2
	And Assign New Incident2
	And Incident search in the Field2
	And Select the first match2
	And Select the Assignment_group2
	And Select the Assigned_to2
	And click Update Button2
	Then Verify first match2
	
	Scenario: Resolve_incident

	And search the Incident in filter3
	And Resolve Incident3
	And Incident search in the Field3
	And Select the first match3
	And WebElement incident state3
	And Update Resolution Information3
	And click Update Button3
	Then Verify first match3
	
		
	Scenario: Delete_incident

	And search the Incident in filter4
	And Delete Incident4
	And Incident search in the Field4
	And Select the first match4
	And Delete the incident4
	Then Verify first match4
	
