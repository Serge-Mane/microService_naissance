package tech.chillo.naissances.shared.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidationsServiceTest {

    @InjectMocks
    ValidationsService validationsService;

    @Test
    void shouldTestThatEmailIsValid() {
        // (Arrange) Définir les variables
        String email = "test@email.com";

        // (Act) Effectuer le test
        this.validationsService.validateEmail(email);

        //(Assert) Afficher les resultats
    }

    @Test
    void shouldThrowExceptionWhenEmailIsInvalid() {
        // Arrange
        String email = null;

        // Act
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> this.validationsService.validateEmail(email)
        );

        // Assert
        assertEquals(exception.getMessage(), "Le mail est requis");
    }

    @Test
    void validatePhone() {
    }
}