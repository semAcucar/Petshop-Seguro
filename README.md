# 🐾 PetShop Seguro: Sistema de Gestão e Segurança para Pet Shop (Atividade N693)

## 1. Escopo e Público-Alvo

* **Público-Alvo (Ação de Extensão):** Microempreendedores do ramo de Pet Shops (clínicas, banho e tosa).
* **Objetivo:** Desenvolver uma aplicação segura para gerenciar clientes, agendamentos e prontuários, priorizando a segurança e a conformidade com a LGPD.

---

## 2. Requisitos Definidos

### Requisitos Funcionais

1.  **Cadastro de Cliente e Pet:** Registro de dados do dono (contato, endereço) e dados dos pets (nome, e alertas de saúde/alergias).
2.  **Agendamento de Serviços:** Permite agendar serviços (banho, tosa, veterinário) com seleção de data, hora e profissional.
3.  **Prontuário de Serviço:** Registro do histórico detalhado de cada serviço prestado.
4.  **Comunicação Automatizada:** Envio de lembretes e promoções **apenas** para clientes que deram consentimento.
5.  **Consulta de Histórico:** Consulta rápida ao prontuário completo de um pet (histórico de serviços e alertas).

### Requisitos Não-Funcionais

1.  **Autenticação Forte:** Exigência de senha forte, *hashing* com *salt* e **limitação de tentativas de login** (*Rate Limiting*).
2.  **Criptografia em Trânsito e Repouso:** Dados sensíveis devem ser criptografados **no banco de dados** e durante o **tráfego** (uso obrigatório de **HTTPS/TLS**).
3.  **Controle de Acesso (RBAC):** Permissões restritas por perfil (Tosador, Gerente), seguindo o **Princípio do Mínimo Privilégio**.
4.  **Registro de Auditoria:** O sistema deve registrar quem, quando e o que foi alterado em operações críticas (ex: edição de prontuário ou exportação de dados).
5.  **Conformidade LGPD:** Registro e armazenamento do **consentimento expresso** do dono para o tratamento dos dados e comunicações.

---

## 3. Modelagem de Arquitetura e Ameaças

### Modelos de Diagramas

### 1. Diagrama de Contexto
<img width="751" height="304" alt="Image" src="https://github.com/user-attachments/assets/b1d0d902-3f33-4342-9a28-95bcedd90676" />

### 2. Diagrama de Componentes
<img width="651" height="376" alt="Diagrama_de_componentes" src="https://github.com/user-attachments/assets/3e8e3039-61ae-4fa1-a939-06e90f66ea51" />

### 3. Diagrama de Fluxo de dados seguros
<img width="661" height="515" alt="Fluxo_de_dados_seguros" src="https://github.com/user-attachments/assets/f44ff021-1a7a-4596-9282-f3c6808f05d1" />

### Modelagem de Ameaças (STRIDE)

| Ameaça | Exemplo no Pet Shop | Mitigação |
| :--- | :--- | :--- |
| **Spoofing** | Falsificação de identidade de funcionário. | **Autenticação Multifator (MFA)**. |
| **Tampering** | Modificação indevida de prontuário. | **Controle de Acesso (RBAC)** rigoroso e **Validação de Entrada**. |
| **Information Disclosure** | Vazamento de contatos do cliente (LGPD). | **Criptografia dos Dados Sensíveis** no banco de dados. |
| **Denial of Service** | Sobrecarga do sistema na tela de agendamento. | **Limite de Taxa (Rate Limiting)**. |

---
