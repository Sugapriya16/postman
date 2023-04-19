Feature: ServiceNow Incident Management

Background:
Given set the endpoint
And add the auth
And add the queryParams as "sysparm_fields" and "category,short_description"

@SmokeTest @RegressionTest @IntegrationTest
Scenario: Create Incident
When post the request with short description as "short_description using post" and category as "software"
Then validate the response as 201

@IntegrationTest
Scenario: Modify Incident
When put the request with short description as "Modified:ServiceNow Incident Using Put"
Then validate put response 

@RegressionTest @IntegrationTest
Scenario: Delete Incident
Then validate delete incident with number as "1f06c6194796211087c17af3836d4377"

