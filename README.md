# ssFirstTask
Task 1.
1. Get data from places.xlsx (place, lat, long) https://drive.google.com/file/d/1Gooa18OcPEQOMDpeZ4BE3M9eBMOBagRa/view?usp=sharing
2. Open https://www.latlong.net/
3. Type in the place name and click Find
4. Assert that lat and long displayed on the site is the same as from the xlsx file
5. Use dataprovider for running tests with all the dada from places.xlxs

# Launch instruction
1. You have to have Mac OSX to open these tests and Goggle Chrome version 75.
2. If you don't have this version of browser or OS - update your browser or change WebDriver version in "pom.xml" file in Surefire plugin section.
3. Open project in your IDE
4. Run Maven test phase (use "mvn test" command)
