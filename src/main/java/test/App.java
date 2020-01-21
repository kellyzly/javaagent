package test;

import com.ea.agentloader.AgentLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{    private static Logger LOGGER = LoggerFactory.getLogger(App.class);


    public static void main1( String[] args ) {
       // same -javaagent:target/premain-agent-1.0-SNAPSHOT.jar
        AgentLoader.loadAgentClass(PermainAgent.class.getName(), null);
       // AgentLoader.loadAgentClass(LambdaFactoryAgent.class.getName(), null);
        ATM atm = new ATM();
        atm.hi();

    }

    public static void main( String[] args ) {
        AgentLoader.loadAgentClass(MyInstrumentationAgent.class.getName(), null);
        ATM app2 = new ATM();
        try {
            app2.withdrawMoney(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
