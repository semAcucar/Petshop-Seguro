// Local: ClientService.java
package com.pedro.petsafe.petshopseguroapi.service; // PACOTE CORRIGIDO

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    // 1. INJETA a ferramenta de criptografia (EncryptionUtil)
    @Autowired
    private EncryptionUtil encryptionUtil;

    // Métodos de exemplo para representar a entidade Cliente
    // (Em Java, 'record' é um jeito simples de definir estruturas de dados)
    public record ClientData(String name, String phone, boolean marketingConsent) {}
    public record ClientEntity(String name, String encryptedPhone, boolean marketingConsent, String consentDate) {}

    /**
     * Processa o cadastro do cliente, criptografando dados e registrando o consentimento.
     */
    public ClientEntity registerClient(ClientData data) {

        // --- ETAPA DE SEGURANÇA E LGPD ---

        // 1. Criptografa o Telefone (Dado Sensível)
        // Isso cumpre o requisito de Criptografia em Repouso.
        String encryptedPhone = encryptionUtil.encrypt(data.phone());

        // 2. Registra o Consentimento (LGPD)
        // Registra se o cliente deu OK para contato de marketing e a data
        String consentDate = data.marketingConsent() ? new java.util.Date().toString() : "N/A";

        // -----------------------------------

        ClientEntity clientEntity = new ClientEntity(
                data.name(),
                encryptedPhone,
                data.marketingConsent(),
                consentDate
        );

        // 3. Salva a Entidade Criptografada no Banco de Dados (D1)
        // (Em um projeto real, você faria: clientRepository.save(clientEntity);)

        return clientEntity;
    }

    /**
     * Descriptografa o telefone do cliente ao buscar no Banco de Dados para visualização.
     */
    public ClientData getClientData(ClientEntity entity) {
        // Descriptografa o telefone para que a aplicação possa usá-lo.
        String decryptedPhone = encryptionUtil.decrypt(entity.encryptedPhone());

        return new ClientData(entity.name(), decryptedPhone, entity.marketingConsent());
    }
}