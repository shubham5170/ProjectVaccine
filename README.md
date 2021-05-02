# Project CoWin Vaccine-India Slot Availabilty Alarm

A java based Alarm to book the available vaccine slot for an individual.

Note: Uses the CoWin API to send a Youtube Video based alarm & the followed API can be found here, https://www.cowin.gov.in/home

To run this, all you need is Maven and Java installed in your machine. If possible an IDE like Eclipse/ Intellij will help. Import this project as maven project and donwload maven dependencies using IDE or maven command: mvn clean install. Then run the main method and thats it.

This project while running will keep on polling for availability for next week and will trigger a youtube alarm if availability is found.
APIs used can be refered here: https://apisetu.gov.in/public/marketplace/api/cowin

Change required:
You need your change district id in line number 24, for that first 
paste this in browser: https://cdn-api.co-vin.in/api/v2/admin/location/states, this will give you state id for your state,
then go to browser and paste: https://cdn-api.co-vin.in/api/v2/admin/location/districts/16 (replace last number with your state ID),
this will give you your district ID. Place this in line number 24 in code. Then above code will search for all vaccine center in your district.

You can go to line number 48 to add more customized filter for your needs, Like a particular hospital which is nearby or a particular Vaccine (Covaxin/ Covishield.)
