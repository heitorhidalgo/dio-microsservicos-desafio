# 🚀 Desafio de Microsserviços com Spring Boot e RabbitMQ

Projeto desenvolvido como solução para o **Desafio de Arquitetura de Microsserviços** proposto pela **Digital Innovation One (DIO)**.
O objetivo é construir uma aplicação distribuída com **API REST**, utilizando **Spring Boot** para orquestrar a comunicação entre múltiplos serviços, praticando conceitos de comunicação síncrona e assíncrona, e utilizando **Docker** para gerenciamento do ambiente.

---

## 📌 Objetivos do Projeto

* Criar uma arquitetura de microsserviços com Spring Boot.
* Implementar comunicação **síncrona** entre serviços via REST (HTTP).
* Implementar comunicação **assíncrona** desacoplada utilizando mensageria com **RabbitMQ**.
* Estruturar camadas lógicas: `controller`, `service`, `repository`, `config`.
* Utilizar **Docker** para gerenciar dependências de ambiente (RabbitMQ).
* Praticar o versionamento de um projeto multi-módulo com Git e GitHub.

---

## 🛠 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3**
* **Spring Data JPA / Hibernate**
* **Spring Web**
* **Spring AMQP (RabbitMQ)**
* **H2 Database** (banco em memória para o `warehouse`)
* **Docker**
* **Maven**
* **Lombok**
* **Postman** (para testes da API)

---

## 📐 Arquitetura do Sistema

O sistema é composto por dois microsserviços independentes que se comunicam para simular o fluxo de uma loja online:

* **`warehouse` (Armazém):** Serviço responsável por gerenciar o inventário de produtos. Ele expõe uma API REST para consultas e consome mensagens de uma fila para processar pedidos.
* **`storefront` (Vitrine):** Serviço que simula a interface com o cliente. Ele consome a API do `warehouse` para exibir produtos e publica mensagens para uma fila ao simular uma compra.
  
---

## 🚀 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/heitorhidalgo/dio-microsservicos-desafio.git](https://github.com/heitorhidalgo/dio-microsservicos-desafio.git)
    cd dio-microsservicos-desafio
    ```

2.  **Pré-requisitos:**
    * Java 21+
    * Maven 3.x+
    * Docker Desktop (instalado e rodando)

3.  **Inicie o RabbitMQ via Docker:**
    Abra um terminal e execute o comando abaixo. Ele irá baixar e iniciar o container do RabbitMQ em segundo plano.
    ```bash
    docker run -d --hostname my-rabbit --name some-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3-management
    ```

4.  **Execute os Microsserviços:**
    Você precisará de dois terminais ou pode executar ambos pela sua IDE.

    * **Para rodar o `warehouse` (porta 8080):**
        ```bash
        cd warehouse
        mvn spring-boot:run
        ```
    * **Para rodar o `storefront` (porta 8081):**
        ```bash
        cd storefront
        mvn spring-boot:run
        ```
    *Observação: Aguarde o `warehouse` iniciar completamente antes de iniciar o `storefront`.*

5.  **Console H2 (Banco de Dados do Warehouse):**
    Acesse em seu navegador para consultar os dados em tempo real:
    ```
    http://localhost:8080/h2-console
    ```
    (Use a URL JDBC `jdbc:h2:mem:testdb`)

---

## 📡 Exemplos de Endpoints (API REST)

### Consulta de Produtos (Comunicação Síncrona)

* `GET http://localhost:8081/storefront/products` → O `storefront` busca e retorna a lista de produtos do `warehouse`.

### Simulação de Compra (Comunicação Assíncrona)

* `POST http://localhost:8081/purchases` → Envia um pedido de compra para a fila do RabbitMQ.

Exemplo de JSON para `POST /purchases`:

```json
{
    "productId": 1,
    "quantity": 2
}
```
### Para verificar o resultado:

1. O Postman receberá uma resposta imediata de sucesso.
2. Observe o console da aplicação warehouse: ele exibirá uma mensagem informando que recebeu o pedido e atualizou o estoque.
3. Consulte o H2 Console para confirmar que a quantidade do produto foi alterada no banco.
---

## 👤 Autor

**Heitor Hidalgo**
* **GitHub:** [heitorhidalgo](https://github.com/heitorhidalgo)
* **LinkedIn:** [Heitor Hidalgo](https://www.linkedin.com/in/heitorhidalgo)
---

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
