package dev.buhanzaz.telegram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.webhook.starter.SpringTelegramWebhookBot;

@Slf4j
@Component
public class MyBot extends SpringTelegramWebhookBot {
    public MyBot(@Value("${telegram.botPath}") String botPath, @Value("${telegram.webhookUrl}") String webhookUrl) {
        super(botPath,
                update -> {
                    log.debug("Sending update {}", update.getMessage().getText());
                    return null;
                },
                () -> {
                    SetWebhook webhook = SetWebhook.builder()
                            .url(webhookUrl)
                            .build();
                    log.debug("Sending webhook {}", webhook.getUrl());
                },
                () -> log.debug("delete webhook"));
    }
}
