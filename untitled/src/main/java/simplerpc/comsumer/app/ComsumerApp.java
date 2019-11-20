package simplerpc.comsumer.app;

import simplerpc.comsumer.service.CalculatorRemoteImpl;
import simplerpc.provider.app.ProviderApp;
import simplerpc.provider.service.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simplerpc.provider.service.Calculator;

/**
 * <p>
 *
 * @author: hzy created on 2018/05/02
 */
public class ComsumerApp {
    private static Logger log = LoggerFactory.getLogger(ComsumerApp.class);

    public static void main(String[] args) {
        Calculator calculator = new CalculatorRemoteImpl();
        int result = calculator.add(1, 2);
        log.info("result is {}", result);
    }
}
