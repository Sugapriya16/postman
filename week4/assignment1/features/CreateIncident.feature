#Create 3 incidents using the same scenario (Hint - use Scenario Outline)
Feature: ServiceNow Incident Management

Scenario Outline: Create Incidents

Given set the endpoint
And add the auth
And add the queryParams as "sysparm_fields" and "category,short_description"
When post the request with short description as "<short_desc>" and category as "<category>"
Then validate the response for below "<order>" "<Key>" & "<Value>" & "<Value1>"



Examples:
|short_desc|category|Order|Key|Value|Value1|
 # 1st data row
 |This is First|software|1|result.category|software||
 # 2nd data row
 |This is Second|hardware|2|result.category|software|inquiry|
  # 3rd data row
 |This is Third|inquiry|3|result.short_description|||


 
