# PROJETO proposal.consumer

## Descrição 📄

Este projeto implementa uma chamada assíncrona usando programação reativa com Spring Boot e WebFlux para processar propostas do banco de dados. O objetivo é buscar propostas com status "processando" e processá-las, transferindo-as do banco temporário para o banco interno geral da empresa.

## Funcionalidades ✨

- 🔄 **Busca assíncrona** de propostas com status "processando"
- ⚙️ **Processamento** de propostas utilizando programação reativa
- 📦 **Transferência** de propostas do banco temporário para o banco interno geral

## Tecnologias Utilizadas 🛠️

- Spring Boot
- Spring WebFlux
- Banco de dados temporário
- Banco de dados interno geral

## Como Executar 🚀

1. **Clone o repositório:**
    ```bash
    git clone <URL_DO_REPOSITORIO>
    ```

2. **Navegue até o diretório do projeto:**
    ```bash
    cd proposal.consumer
    ```

3. **Compile e execute o projeto:**
    ```bash
    ./mvnw spring-boot:run
    ```

## Configurações ⚙️

Certifique-se de configurar as conexões com os bancos de dados temporário e interno no arquivo `application.properties` ou `application.yml`.

---

# PROJETO proposal.operations

## Descrição 📄

Este projeto recebe um JSON contendo as informações de uma proposta (informações do contratante e do contratado) e processa essa proposta. As principais funcionalidades incluem salvar, buscar e deletar propostas.

## Funcionalidades ✨

- 💾 **Salvar** propostas
- 🔍 **Buscar** propostas
- 🗑️ **Deletar** propostas

## Tecnologias Utilizadas 🛠️

- Spring Boot
- PostgreSQL

## Como Executar 🚀

### Usando Docker:

swagger : [clique aqui](http://localhost:91/swagger-ui/index.html)


1. Execute o comando para subir o banco de dados:
    ```bash
    docker compose up database
    ```
2. Execute o comando para subir o serviço de operações de propostas:
    ```bash
    docker compose up proposal-operations
    ```

### Localmente:

swagger : [clique aqui](http://localhost:8091/swagger-ui/index.html)

1. Execute o comando para subir o banco de dados:
    ```bash
    docker compose up database
    ```
2. Após a finalização do container do banco de dados, execute o projeto em sua IDE de preferência.

## Configurações ⚙️

Certifique-se de que as configurações do banco de dados estão corretas no arquivo `application.properties` ou `application.yml` de acordo com o ambiente de execução (local ou docker).

## Endpoints da API 🌐

- **Salvar Proposta**: `POST /proposals`
    - **Body**: JSON com as informações da proposta
    - **Exemplo**:
        ```bash
        curl --location 'http://localhost:8091/v1/proposals' \
        --header 'x-api-key: 54919557EKQHH76Y47DSAGL9OEASST98UBN5Y1X4S8SAW9DXGT2OE5RMCXQAOIBZ' \
        --header 'Content-Type: application/json' \
        --header 'Cookie: JSESSIONID=48F582C5218FA3F66A3F0E8FEF09A370' \
        --data-raw '{
          "proposal": {
            "date": "2024-07-14",
            "contractor": {
              "name": "Company A",
              "cnpj": "13.252.981/0001-06",
              "address": "Rua Principal, 1000, São Paulo, SP, Brazil",
              "phone": "+55 (11) 1234-5678",
              "email": "contact@companyA.com"
            },
            "contractee": {
              "name": "Company B",
              "cnpj": "11.999.727/0001-40",
              "address": "Avenida Secundária, 200, Rio de Janeiro, RJ, Brazil",
              "phone": "+55 (21) 2345-6789",
              "email": "contact@companyB.com"
            },
            "contract_description": "Development of a business management system to automate internal processes and improve operational efficiency.",
            "value": "R$ 150,000.00",
            "term": "6 months"
          }
        }'
        ```

- **Buscar Proposta**: `GET /proposals/{proposalId}`
    - **Parâmetro**: `proposalId` da proposta
    - **Exemplo**:
        ```bash
        curl --location 'http://localhost:8091/v1/proposals/PRPST-4' \
        --header 'x-api-key: 54919557EKQHH76Y47DSAGL9OEASST98UBN5Y1X4S8SAW9DXGT2OE5RMCXQAOIBZ' \
        --header 'Cookie: JSESSIONID=48F582C5218FA3F66A3F0E8FEF09A370'
        ```
