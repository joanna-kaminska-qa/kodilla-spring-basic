package com.kodilla.spring.basic.dependency_injection;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SimpleApplicationTest {

    @Test
    void testProcessMessageWithEmailService() {
        // Tworzymy mocka serwisu wiadomości
        MessageService messageService = mock(EmailMessageService.class);

        // Tworzymy instancję SimpleApplication z wstrzykniętym serwisem wiadomości
        SimpleApplication application = new SimpleApplication(messageService);

        // Wywołujemy metodę processMessage
        application.processMessage("Test message", "receiver@mail.com");

        // Sprawdzamy, czy metoda send została wywołana na mocku z odpowiednimi parametrami
        verify(messageService).send("Test message", "receiver@mail.com");
    }

    @Test
    void testProcessMessageWithFacebookService() {
        // Tworzymy mocka serwisu wiadomości
        MessageService messageService = mock(FacebookMessageService.class);

        // Tworzymy instancję SimpleApplication z wstrzykniętym serwisem wiadomości
        SimpleApplication application = new SimpleApplication(messageService);

        // Wywołujemy metodę processMessage
        application.processMessage("Test message", "receiver@mail.com");

        // Sprawdzamy, czy metoda send została wywołana na mocku z odpowiednimi parametrami
        verify(messageService).send("Test message", "receiver@mail.com");
    }

    @Test
    void testCheckReceiverShouldReturnTrue() {
        SimpleApplication application = new SimpleApplication(new FacebookMessageService());

        // Sprawdzamy, czy metoda checkReceiver zwróci true dla prawidłowego adresu
        assertTrue(application.checkReceiver("receiver@mail.com"));
    }

    @Test
    void testCheckReceiverShouldReturnFalse() {
        SimpleApplication application = new SimpleApplication(new FacebookMessageService());

        // Sprawdzamy, czy metoda checkReceiver zwróci false dla pustego adresu
        assertFalse(application.checkReceiver(""));
        assertFalse(application.checkReceiver(null));
    }
}
