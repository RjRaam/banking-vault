package com.bankingvault.backend.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.bankingvault.backend.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Converter
public class CryptoConverter implements AttributeConverter<String, String> {

    private static CryptoService cryptoService;

    @Autowired
    public void setCryptoService(CryptoService cryptoService) {
        CryptoConverter.cryptoService = cryptoService;
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (attribute == null) return null;
        try {
            return cryptoService.encrypt(attribute);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting", e);
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        try {
            return cryptoService.decrypt(dbData);
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting", e);
        }
    }
}
