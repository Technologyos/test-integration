package com.technologyos.unittest.repositories;

import com.technologyos.unittest.entities.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
   @Autowired
   private TestEntityManager testEntityManager;

   @Autowired
   private UserRepository usersRepository;

   private final String userId1 = UUID.randomUUID().toString();
   private final String userId2 = UUID.randomUUID().toString();
   private final String email1 = "asalazarj@gmail.com";
   private final String email2 = "jaime@gmail.com";

   @BeforeEach
   void setup() {
      // Creating first user
      UserEntity userEntity = new UserEntity();
      userEntity.setUserId(userId1);
      userEntity.setEmail(email1);
      userEntity.setEncryptedPassword("test123");
      userEntity.setFirstName("Armando");
      userEntity.setLastName("Salazar");
      testEntityManager.persistAndFlush(userEntity);

      // Creating second user
      UserEntity userEntity2 = new UserEntity();
      userEntity2.setUserId(userId2);
      userEntity2.setEmail(email2);
      userEntity2.setEncryptedPassword("test321");
      userEntity2.setFirstName("Jaime");
      userEntity2.setLastName("Salazar");
      testEntityManager.persistAndFlush(userEntity2);
   }

   @Test
   void testFindByEmail_whenGivenCorrectEmail_returnsUserEntity() {
      // Act
      UserEntity storedUser = usersRepository.findByEmail(email1);

      // Assert
      assertEquals(email1, storedUser.getEmail(),
         "The returned email address does not match the expected value");
   }

   @Test
   void testFindByUserId_whenGivenCorrectUserId_returnsUserEntity() {
      // Act
      UserEntity storedUser = usersRepository.findByUserId(userId2);

      // Assert
      assertNotNull(storedUser,
         "UserEntity object should not be null");
      assertEquals(userId2, storedUser.getUserId(),
         "Returned userId does not much expected value");
   }

   @Test
   void testFindUsersWithEmailEndsWith_whenGiveEmailDomain_returnsUsersWithGivenDomain() {
      // Arrange
      UserEntity userEntity = new UserEntity();
      userEntity.setUserId(UUID.randomUUID().toString());
      userEntity.setEmail("miriam@outlook.com");
      userEntity.setEncryptedPassword("test123");
      userEntity.setFirstName("Miriam");
      userEntity.setLastName("Baeza");
      testEntityManager.persistAndFlush(userEntity);

      String emailDomainName = "@outlook.com";

      // Act
      List<UserEntity> users = usersRepository.findUsersWithEmailEndingWith(emailDomainName);

      // Assert
      assertEquals(1, users.size(),
         "There should be one user in the list");
      assertTrue(users.get(0).getEmail().endsWith(emailDomainName),
         "User's email does not end with target domain name");
   }
}
