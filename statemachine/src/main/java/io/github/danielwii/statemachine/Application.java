package io.github.danielwii.statemachine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

import javax.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Resource
    private StateMachine<States, Events> stateMachine;

    @Resource
    private StateMachine<States, Events> testStateMachine;

    @Override
    public void run(String... args) throws Exception {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }

}
