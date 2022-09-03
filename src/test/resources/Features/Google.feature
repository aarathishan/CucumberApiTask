#Author: your.email@your.domain.com
Feature: Google API
  
  Scenario: Add Google Location
    Given I want to add payload
    When User submit "POST" api
    Then User validate the status code is 200
    
  
