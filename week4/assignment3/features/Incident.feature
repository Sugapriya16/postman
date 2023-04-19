Feature: ServiceNow Incident Management



Scenario: Create Incident
When post the request with short description as "short_description using post" and category as "software"
Then validate the response as 201


Scenario: Modify Incident
When put the request with short description as random alphanumberic
Then validate put response 

Scenario: Delete Incident
When delete request
Then validate delete incident




