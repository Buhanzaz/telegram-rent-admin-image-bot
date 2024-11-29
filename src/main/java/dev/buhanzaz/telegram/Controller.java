package dev.buhanzaz.telegram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@RestController
public class Controller {
    // TODO доделать
    @PostMapping("${telegram.botPath}")
    public void update(@RequestBody Update update) {
        log.debug("Update {}", update.getMessage().getText());
    }
}
