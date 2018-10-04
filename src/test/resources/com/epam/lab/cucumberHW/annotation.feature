Feature: Automated log in test 

Scenario Outline: 
	User log in to to Gmail page with right credentials
	Given User is on Gmail login page 
	When He types email as <login> 
	And He types password as <password> 
	Then User should be redirected to his Gmail page 
	Examples: 
		| login                         | password       | 
		| "lab.test.sending@gmail.com"  | "a1234567890a" | 
		| "lab.test.sending1@gmail.com" | "a1234567890a" | 
		| "lab.test.sending2@gmail.com" | "a1234567890a" | 
		| "lab.test.sending3@gmail.com" | "a1234567890a" | 
		| "lab.test.sending4@gmail.com" | "a1234567890a" | 
		
