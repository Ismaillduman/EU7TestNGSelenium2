# if test fails
        1. if(result.getStatus()==ITestResult.FAILURE){

## RECORD THE NAME of failed test case
.  extentLogger.fail(result.getName());

## take the screenshot and return location of screenshot

.  String screenShotPath= BrowserUtils.getScreenshot(result.getName());

## add your screenshot and put inside the report

. extentLogger.addScreenCaptureFromPath(screenShotPath);

## capture the exception and put inside the report

. extentLogger.fail(result.getThrowable());

