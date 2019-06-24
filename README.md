# ssFirstTask
Task 1.
1. Get data from places.xlsx (place, lat, long) https://drive.google.com/file/d/1Gooa18OcPEQOMDpeZ4BE3M9eBMOBagRa/view?usp=sharing
2. Open https://www.latlong.net/
3. Type in the place name and click Find
4. Assert that lat and long displayed on the site is the same as from the xlsx file
5. Use dataprovider for running tests with all the dada from places.xlxs

# Launch instruction
1. Make sure that your Goggle Chrome version is 75.
2. If you don't have this version of browser - update your browser or change WebDriver version in "pom.xml" file in Surefire plugin section or "webdriver.version" property.
4. Run Maven test phase (use "mvn clean test" command)

# Launch with RemoteWebDriver (with Docker)
--- Make sure that docker is installed on your computer! ---
1. Open your favorite terminal
2. Go to "scripts" folder in project main directory (.../ssFirstTask/Task/scripts)
3. Run command "./run-tests.sh"
