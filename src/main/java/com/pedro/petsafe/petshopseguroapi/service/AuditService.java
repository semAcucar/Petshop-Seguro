// Local: AuditService.java
package com.pedro.petsafe.petshopseguroapi.service; // PACOTE CORRIGIDO

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AuditService {

    /**
     * Registra uma ação crítica no sistema (requisito P4: Registro de Auditoria/Log).
     */
    public void registerAuditLog(String username, String action, String details) {
        String timestamp = LocalDateTime.now().toString();

        // Formato do Log
        String logEntry = String.format(
                "[%s] [AUDITORIA] Usuário: %s | Ação: %s | Detalhes: %s",
                timestamp, username, action, details
        );

        // Loga a entrada de auditoria.
        System.out.println(logEntry);
    }
}