package org.example.expert.data;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.user.entity.User;
import org.example.expert.domain.user.enums.UserRole;
import org.example.expert.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    @Value("${app.init-data:false}")
    private boolean initData;

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) {
        if (!initData) return;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            String nickname = "user_" + UUID.randomUUID();
            users.add(new User("test" + i + "@test.com", "pw", UserRole.USER, nickname));
        }
        userRepository.saveAll(users);
    }
}
