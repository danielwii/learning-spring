package io.github.danielwii.statemachine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@Slf4j
@WithStateMachine(id = "测试1")
public class EventConfig {

    @OnTransition(target = "UNPAID")
    public void create() {
        log.info("[x] 订单创建，待支付");
    }

    @OnTransition(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void pay() {
        log.info("[x] 用户完成支付，待收货");
    }

    @OnTransition(source = "WAITING_FOR_RECEIVE", target = "DONE")
    public void receive() {
        log.info("[x] 用户已收货，订单完成");
    }


}
