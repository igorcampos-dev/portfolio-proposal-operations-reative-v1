# PROJETO `proposal`

Este repositório armazena dois projetos interdependentes:

1. **`proposal.consumer`**: Uma aplicação baseada em **Spring Boot** e **Spring WebFlux** que utiliza programação reativa para processar propostas armazenadas em um banco de dados. Ela realiza buscas assíncronas para identificar propostas com o status "processando" e as transfere do banco de dados temporário para o banco de dados interno geral da empresa.

2. **`proposal.operations`**: Um serviço CRUD que salva e busca propostas em um banco de dados PostgreSQL.

## Funcionalidades ✨

- **`proposal.consumer`**:
    - 🔄 **Busca Assíncrona**: Identifica propostas com status "processando" de forma não bloqueante.
    - ⚙️ **Processamento Reativo**: Utiliza a programação reativa para movimentar propostas entre bancos de dados.

- **`proposal.operations`**:
    - 💾 **Salvar**: Adiciona novas propostas ao banco de dados.
    - 🔍 **Buscar**: Recupera propostas existentes.

## Tecnologias Utilizadas 🛠️

- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring WebFlux**: Framework para criação de aplicações reativas e não bloqueantes.
- **PostgreSQL**: Banco de dados relacional utilizado pelo `proposal.operations`.
- **Docker**: Para gerenciamento de contêineres e serviços.

## Como Executar 🚀

### Inicialização Local

**Atenção!!** Para a execução dos projetos, siga a ordem abaixo para garantir que todos os serviços e tabelas sejam inicializados corretamente:

1. **Inicie o banco de dados com Docker**:
    ```bash
    docker compose up database
    ```

2. **Inicie o projeto `proposal.operations`**:
    - Após o banco de dados estar ativo, inicie o serviço de operações de propostas.

3. **Inicie o projeto `proposal.consumer`**:
    - Com o banco de dados e o serviço `proposal-operations` prontos, inicie o projeto localmente na sua IDE de preferência.

### Inicialização no Docker

**Atenção!!** Para a execução dos projetos, um único comando é suficiente para iniciar todos os serviços, incluindo o banco de dados e ambos os projetos.

1. **Inicie todos os serviços com Docker Compose**:
    ```bash
    docker compose up
    ```

## Endpoints da API 🌐

### `proposal.operations`

- **Salvar Proposta**: `POST /proposals`
    - **Body**: JSON com as informações da proposta
    - **Exemplo**:
        ```bash
        curl --location 'http://localhost:8091/v1/proposals' \
        --header 'x-api-key: 54919557EKQHH76Y47DSAGL9OEASST98UBN5Y1X4S8SAW9DXGT2OE5RMCXQAOIBZ' \
        --header 'Content-Type: application/json' \
        --header 'Cookie: JSESSIONID=48F582C5218FA3F66A3F0E8FEF09A370' \
        --data-raw '{ "proposal": {
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
                      "value": "150000.15",
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

### `proposal.operations`

- **Documentação Swagger**: Acesse a documentação da API Swagger para `proposal.operations` em :

- **Local:** [clique aqui](http://localhost:8091/swagger-ui/index.html)
- **docker:** [clique aqui](http://localhost:8091/swagger-ui/index.html)
