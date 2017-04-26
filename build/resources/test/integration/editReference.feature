Feature: user can edit references in the database

Scenario: user can edit a reference
Given user is in the main page and there is a reference with the title "testireferenssi" in the database
When button with the text "Muokkaa" next to the reference with the title "testireferenssi" is pressed
When title "testireferenssiEDIT" is entered in the edit-form
Then there is a reference with the title "testireferenssiEDIT" in the database