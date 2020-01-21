package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class PermainAgent {
    private static Logger LOGGER = LoggerFactory.getLogger(PermainAgent.class);



    // make a jar  mvn package  (modify pom.xml manifestEntries to generate target/premain-agent-1.0-SNAPSHOT.jar
    private static Instrumentation INST;

    public static void agentmain(String agentArgs, Instrumentation inst) {
        premain(agentArgs, inst);
    }

    public static void premain(String agentArgs, Instrumentation inst) {
        INST = inst;
        process();
    }

    private static void process() {
        INST.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className,
                                    Class<?> clazz,
                                    ProtectionDomain protectionDomain,
                                    byte[] byteCode) throws IllegalClassFormatException {
               if( !className.startsWith("sun") && !className.startsWith("java")) {

                   LOGGER.info(String.format("Process by ClassFileTransformer,target class = %s", className));
               }
               return  byteCode;
            }
        });
    }
}