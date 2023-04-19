Feature: ServiceNow Incident Management

Scenario: Create Incidents

Given set the endpoint
And add the auth
And add the queryParams as "sysparm_fields" and "category,short_description,sys_id,urgency,approval,knowledge,number"
When post the request with short description  as "short_description using post" and category as "hardware"
Then validate the response for below
|result.urgency|3|
|result.approval|not requested|
|result.knowledge|false|
|result.number|INC|
