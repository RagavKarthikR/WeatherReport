$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("weather.feature");
formatter.feature({
  "line": 1,
  "name": "Weather Report Validation",
  "description": "",
  "id": "weather-report-validation",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Verify the landing page of the weather report",
  "description": "",
  "id": "weather-report-validation;verify-the-landing-page-of-the-weather-report",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Initiate the chrome driver",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Navigate to weather report url",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Verify the landing page",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefinition.initiate_the_chrome_driver()"
});
formatter.result({
  "duration": 69071600,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.navigate_to_weather_report_url()"
});
formatter.result({
  "duration": 33949655900,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.readWeather()"
});
formatter.result({
  "duration": 325800,
  "error_message": "junit.framework.AssertionFailedError: Weather report difference is 272.93\r\n\tat junit.framework.Assert.fail(Assert.java:57)\r\n\tat UpMan.WeatherReport.utilites.weathercomaprision(utilites.java:79)\r\n\tat UpMan.WeatherReport.Stepdefinition.readWeather(Stepdefinition.java:28)\r\n\tat ✽.Then Verify the landing page(weather.feature:6)\r\n",
  "status": "failed"
});
});