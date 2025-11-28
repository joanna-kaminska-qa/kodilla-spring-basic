package com.kodilla.spring.basic.dependency_injection;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class FacebookMessageServiceTest {

    @Test
    void testSendMessage() {
        // Tworzymy mocka systemu wyjścia (np. konsoli)
        MessageService messageService = mock(FacebookMessageService.class);

        // Wywołujemy metodę send
        messageService.send("Hello, Facebook!", "receiver@mail.com");

        // Sprawdzamy, czy metoda send została wywołana
        verify(messageService).send("Hello, Facebook!", "receiver@mail.com");
    }
}
