package tests.listeners;

import config.ConfigManager;
import lombok.extern.log4j.Log4j2;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Log4j2
public class RetryManager implements IRetryAnalyzer {
    private int counter = 0;
    private int maxRetryAttempts = ConfigManager.getConfiguration().maxRetryAttempts();

    @Override
    public boolean retry(ITestResult result) {
        if (result.isSuccess()) {
            result.setStatus(1);    // sets SUCCESS status
            return false;
        }
        result.setStatus(2);        // sets FAILURE status
        if (counter < maxRetryAttempts) {
            counter++;
            log.warn("Test is failed, retrying one more time");
            return true;            // tells TestNG to retry test
        }
        return false;
    }
}
