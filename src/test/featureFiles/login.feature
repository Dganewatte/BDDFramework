Feature: login feature
  @login
Scenario: validate title
  Given Launch the url
  And verify title as <title>
  Then I close the browser