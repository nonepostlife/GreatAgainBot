package ru.postlife.telegram.bot.GreatAgainBot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.postlife.telegram.bot.GreatAgainBot.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
