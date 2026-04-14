# Project Spreadsheet Tracking

## Overview 
This document tracks the project spreadsheet used to manage team responsibilities 
rubric requirements

**Spreadsheet Link:** [Project Spreadsheet](https://docs.google.com/spreadsheets/d/1Fdr9Lq8LOAMNTUTgY8Xc5cZquWC5nMPtzzIEZoAwFw8/edit?usp=sharing) 

## Responsibilities
- Assign team members to required and optional items
- Ensure each item is linked to:
  - GitHub issue #
  - Branch name
  - Pull Request #
  - Maintain status updates (planned -> in progress -> complete -> dropped)
  - Verify all requirements are satisfied before submission

## Notes
- Submission checklist could use calculations to automatically update changes within the spreadsheet
- All items must be fully satisfied before final submission

## subissue #9 Assign Required Items
Required items claimed and assigned to each member within the spreadsheet. Balance of distributed 
tasks will be resolved with the addition of optional items:
  - Persistence -> Vincent Marinello-Sweeney
  - Scene Factory -> Ariya Briscoe
  - Login Scene -> Ariya Briscoe
  - Design Document -> Brianna Tomasek
  - Video -> Jessica Sandoval 
  - Updated Diagram -> Brianna Tomasek
  - Project Spreadsheet -> Jessica Sandoval

## subissue #10 Assign Optional Items
Optional items claimed and assigned to members with fewer points, ensuring all members are slightly 
above the required minimum. 
- Total Team points > 200
- Corrected miscalculation of cell E63, E64, and E65 with formula: 
  -     =sumif($H$11:$H$53,"="&A63,F11:F54)
  -     =sumif($H$11:$H$53,"="&A64,F11:F55)
  -     =sumif($H$11:$H$53,"="&A65,F11:F56)
  Which references the correct corresponding tasks from its original formula:
  -     =sumif($H$11:$H$53,"="&A64,F12:F55)
  -     =sumif($H$11:$H$53,"="&A64,F13:F55)
  -     =sumif($H$11:$H$53,"="&A64,F14:F55)

## subissue #12 Include Calculations for Submission Checklist
The initial state of the Submission Checklist represents the requirements with []. This requires manual
updates. I included calculations for cells C72 - C75 to automatically update with clear indicators, showing 
whether a certain criteria has been met: 

All required solo-claim items have a Claimed By + Issue # + Branch + PR #
-     =IF(COUNTBLANK(H11:K17)=0,"✔", "✘")
All Required per-student items have all four members filled in 
-     =IF(COUNTIFS($G$19:$G$37,"Per-student",$H$19:$H$37,"<>")=COUNTIF($G$19:$G$37,"Per-student"),"✔","✗")
Every student is at or above their minimum 
-     =IF(MIN($E$62:$E$65)>=47,"✔","✗")
Team total is at or above 200
-     =IF($C$67>=200,"✔","✗")

