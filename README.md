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

### Modelos de Diagramas (Mínimo 3)

* **[AQUI SERÃO INSERIDOS OS DIAGRAMAS: Contexto, Componentes e Fluxo de Dados]**
    * *Nota:* O professor conferirá a inserção das imagens dos diagramas após a criação.

### Modelagem de Ameaças (STRIDE)

| Ameaça | Exemplo no Pet Shop | Mitigação |
| :--- | :--- | :--- |
| **Spoofing** | Falsificação de identidade de funcionário. | **Autenticação Multifator (MFA)**. |
| **Tampering** | Modificação indevida de prontuário. | **Controle de Acesso (RBAC)** rigoroso e **Validação de Entrada**. |
| **Information Disclosure** | Vazamento de contatos do cliente (LGPD). | **Criptografia dos Dados Sensíveis** no banco de dados. |
| **Denial of Service** | Sobrecarga do sistema na tela de agendamento. | **Limite de Taxa (Rate Limiting)**. |

---

### 3. Salve as Alterações

* **Ação:** Role a página até o final e clique no botão verde **Commit changes**.

Com isso, o requisito de **Documentação no README (1,0 ponto)** estará totalmente atendido!

Seu próximo passo é desenhar os **3 Diagramas de Arquitetura** e inseri-los no espaço reservado no `README`.
