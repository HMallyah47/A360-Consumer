package com.mm.streaming.A360Consumer.listener;

import com.mm.streaming.A360Consumer.model.Policy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Consumer {

    @Value("${policy.destination.topic}")
    private String destinationTopic;

    @Value("${rest.proxy.publish.url}")
    private String publish_via_rest_proxy_url;

    @KafkaListener(topics = "${policy.source.topic}", groupId = "${consumer.group}", containerFactory = "policyKafkaListenerFactory")
    public void consume(Policy policy){
        System.out.println("Consumed message from source topic:" + policy);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/vnd.kafka.v2+json");
        headers.set("content-type", "application/vnd.kafka.json.v2+json");
        String record = String.format("{\"records\":[{\"value\":%s}]}", policy.toString());
        System.out.println("Published message via Rest Proxy to destination topic: " + record);
        HttpEntity<String> request = new HttpEntity<>(record, headers);
        System.out.println(restTemplate.postForObject(publish_via_rest_proxy_url + destinationTopic, request, String.class));
    }

}
