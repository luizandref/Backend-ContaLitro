package com.contalitro.backend.mqtt;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MqttSubscriberHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @ServiceActivator(inputChannel = "mqttInputChannel")
    public void handleMessage(Message<String> message) {
        String payload = message.getPayload();
        String topic = (String) message.getHeaders().get("mqtt_receivedTopic");

        try {
            String equipamentoId = extrairEquipamentoDoTopico(topic);

            JsonNode json = objectMapper.readTree(payload);

            System.out.println("Mensagem MQTT recebida do veículo " + equipamentoId + ": " + payload);

        } catch (Exception e) {
            System.err.println("Erro ao processar mensagem MQTT malformada: " + payload + " | Erro: " + e.getMessage());
        }
    }

    private String extrairEquipamentoDoTopico(String topic) {
        if (topic != null && topic.contains("/")) {
            String[] partes = topic.split("/");
            return partes[partes.length - 1];
        }
        return "desconhecido";
    }
}