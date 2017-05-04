Feature: User can list their references

Scenario: No pagination with less references than page size
    Given There are 3 references
    When user is on main page with pagination size 5
    Then pagination is not available


Scenario: Pagination with more references than page size
    Given There are 3 references
    When user is on main page with pagination size 2
    Then pagination is available