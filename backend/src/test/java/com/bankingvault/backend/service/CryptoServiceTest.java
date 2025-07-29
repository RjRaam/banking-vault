package com.bankingvault.backend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class CryptoServiceTest {

    @Autowired
    private CryptoService cryptoService;

    @Test
    void testEncryptAndDecrypt() throws Exception {
        String original = "1234567890";
        String encrypted = cryptoService.encrypt(original);
        String decrypted = cryptoService.decrypt(encrypted);

        assertThat(decrypted).isEqualTo(original);
        System.out.println("Original: " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
