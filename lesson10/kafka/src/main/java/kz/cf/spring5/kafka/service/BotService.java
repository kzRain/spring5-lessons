package kz.cf.spring5.kafka.service;

import kz.cf.spring5.kafka.listener.MyListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Logger;

@Service
public class BotService extends TelegramLongPollingBot {

    Logger logger = Logger.getLogger(MyListener.class.getName());

    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String botToken;
    private Long chatId = null;

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        logger.info(update.getMessage().getText());
        chatId = update.getMessage().getChatId();
    }

    @KafkaListener(topics = "codeforce", groupId = "telegrambot", containerFactory = "telegramKafkaListenerContanerFactory")
    public void process1Queue1(String message) {
        if (chatId!=null) {
            try {
                execute(new SendMessage().setChatId(chatId).setText(message));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            logger.info("ChatId is null");
        }

    }
}
