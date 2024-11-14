package tech.chillo.naissances.profiles;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.springframework.boot.jdbc.EmbeddedDatabaseConnection.H2;

@DataJpaTest
@AutoConfigureTestDatabase(connection = H2)
public class ProfilesRepositoryTest {
    @Autowired
    ProfilesRepository profilesRepository;

    @BeforeEach
    void setUp() {
        Profile profileOne = Profile.builder().email("one@email.test").build();
        Profile profileTwo = Profile.builder().email("two@email.test").build();
        this.profilesRepository.saveAll(List.of(profileOne, profileTwo));
    }

    @AfterEach
    void tearDown() {
        this.profilesRepository.deleteAll();
    }

    @Test
    void shouldReturnListOfProfiles() {

        // Arrange

        // Act
        List<Profile> profiles = this.profilesRepository.findAll();

        // Assert
        Assertions.assertEquals(2, profiles.size());
    }

    @Test
    void shouldReturnProfileByEmail() {

        // Arrange

        // Act
        Optional<Profile> profile = this.profilesRepository.findByEmail("two@email.test");

        // Assert
        Assertions.assertTrue(profile.isPresent());
    }

    @Test
    void shouldReturnEmptyProfileByEmail() {

        // Arrange

        // Act
        Optional<Profile> profile = this.profilesRepository.findByEmail("three@email.test");

        // Assert
        Assertions.assertTrue(profile.isEmpty());
    }
}
