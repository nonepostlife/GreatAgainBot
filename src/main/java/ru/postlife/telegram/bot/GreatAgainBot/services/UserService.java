package ru.postlife.telegram.bot.GreatAgainBot.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.postlife.telegram.bot.GreatAgainBot.entities.User;
import ru.postlife.telegram.bot.GreatAgainBot.repositories.UserRepository;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findById(Long chatId) {
        return userRepository.findById(chatId);
    }

    public void createNewUser(Message message) {
        long chatId = message.getChatId();

        if (findById(chatId).isEmpty()) {
            Chat chat = message.getChat();
            User user = new User();
            user.setChatId(chatId);
            user.setFirstName(chat.getFirstName());
            user.setLastName(chat.getLastName());
            user.setUserName(chat.getUserName());
            userRepository.save(user);
            log.info("Save new User: " + user);
        }
    }
}
