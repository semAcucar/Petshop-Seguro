// Local: EncryptionUtil.java
package com.pedro.petsafe.petshopseguroapi.service; // PACOTE CORRIGIDO

import org.springframework.stereotype.Component;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class EncryptionUtil {

    private static final String ALGORITHM = "AES";
    // CHAVE SECRETA: Use exatamente 16 caracteres para AES-128
    private static final String SECRET_KEY = "suachave16bytes!";

    private SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);

    /**
     * Criptografa o dado sensível antes de salvar no Banco de Dados (D1).
     */
    public String encrypt(String value) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encryptedValue = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encryptedValue);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criptografar dado.", e);
        }
    }

    /**
     * Descriptografa o dado ao ser lido do Banco de Dados (D1).
     */
    public String decrypt(String encryptedValue) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decryptedValue = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
            return new String(decryptedValue);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao descriptografar dado.", e);
        }
    }
}