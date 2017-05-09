package com.voterapi.candidate.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CandidateConfig {

    @Bean
    public Queue queue() {
        return new Queue("voter.rpc.requests");
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("voter.rpc");
    }

    @Bean
    public Binding binding(DirectExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("rpc");
    }

    @Bean
    public Queue candidateQueue() {
        return new Queue("candidates.queue");
    }

//    @Bean
//    public FanoutExchange candidateFanoutExchange() {
//        return new FanoutExchange("candidate.fanout");
//    }
}