CREATE TABLE TB_PROPOSAL (
    id SERIAL PRIMARY KEY,
    proposal_id VARCHAR(255) NOT NULL,
    date DATE,
    name_contractor VARCHAR(255),
    cnpj_contractor VARCHAR(20),
    address_contractor VARCHAR(255),
    phone_contractor VARCHAR(20),
    email_contractor VARCHAR(255),
    name_contracted VARCHAR(255),
    cnpj_contracted VARCHAR(20),
    address_contracted VARCHAR(255),
    phone_contracted VARCHAR(20),
    email_contracted VARCHAR(255),
    contract_description TEXT,
    value DECIMAL(15, 2),
    term VARCHAR(255),
    status VARCHAR(10) CHECK (status IN ('PROCESS', 'FINISHED', 'ERROR'))
);
