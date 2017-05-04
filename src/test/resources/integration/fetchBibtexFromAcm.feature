Feature: user can fetch reference info from ACM library

  Scenario: user can retrieve data for the example reference from ACM
    Given uusi viite is selected
    When acm data is retrieved for link "http://dl.acm.org/citation.cfm?id=2380552.2380613&coll=DL&dl=GUIDE&CFID=293493744&CFTOKEN=23554239"
    Then the text "Luukkainen, Matti and Vihavainen, Arto and Vikberg, Thomas" is present in the "author" field

  Scenario: user can retrieve data for arbitrary reference from ACM
    Given uusi viite is selected
    When acm data is retrieved for link "http://dl.acm.org/citation.cfm?id=2753011&CFID=756104169&CFTOKEN=88259933"
    Then the text "J. Comput. Sci. Coll." is present in the "journal" field

  Scenario: user cannot retrieve data for invalid link
    Given uusi viite is selected
    When acm data is retrieved for link ""
    Then then fetch status becomes "Virheellinen linkki"
