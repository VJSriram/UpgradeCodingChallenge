Feature: To verify for correct loanAppUUid API responds OK

@API_Test
Scenario: To verify Rest service - POST Method for loanAppUuid
	Given when API is called with correct loanappUuid "b908e747-4a4f-4afb-8af0-7c13c81721df"
	Then Respose status code should be 200
	And response should include "PERSONAL_LOAN" for productType 
	And when I pass different loanAppUuid "b908e747-4a4f-4afb-8af0" then error code 500 is received
