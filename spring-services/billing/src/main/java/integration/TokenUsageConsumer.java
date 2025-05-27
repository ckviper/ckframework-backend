package integration;

import dto.TokenUsageDto;
import org.springframework.stereotype.Service;

@Service
public class TokenUsageConsumer {

    @RabbitListener(queues = "token-usage-queue")
    public void listen(TokenUsageDto message) {

    }
}