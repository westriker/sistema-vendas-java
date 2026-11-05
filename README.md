# Sistema de Vendas em Java

Sistema de gestão de vendas desenvolvido em **Java 17**, estruturado por camadas, utilizando **Apache Maven** para gestão de dependências e automação de build, e **JUnit 5** para testes unitários automatizados.

## 🛠️ Tecnologias Utilizadas
- **Java 17** (Eclipse Adoptium)
- **Apache Maven**
- **JUnit 5**

## 📂 Estrutura do Projeto
- `src/main/java/com/vendas/model`: Contém as entidades principais de negócio (`Cliente`, `Produto`).
- `src/main/java/com/vendas/service`: Contém a lógica de negócio e regras de transação (`VendaService`).
- `src/test/java/com/vendas/service`: Contém os testes unitários (`VendaServiceTest`).

## 🚀 Como Executar e Testar
1. Certifica-te de que tens o Java 17 e o Maven configurados no teu ambiente.
2. Abre o terminal integrado na pasta raiz do projeto.
3. Executa o seguinte comando para compilar e correr todos os testes:
   ```bash
   mvn clean test