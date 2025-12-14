
# Título do Projeto

Uma breve descrição sobre o que esse projeto faz e para quem ele é

# 🛠 Gestão de Estoque e Movimentação de Ferramentas (Frontend)

##  Visão Geral

Este é o repositório frontend do sistema de gerenciamento e controle de estoque de ferramentas. A aplicação foi desenvolvida em **Angular** e permite o registro eficiente de movimentações (entradas, saídas e devoluções), garantindo a rastreabilidade do uso das ferramentas na sua empresa.

---

## ✨ Funcionalidades Principais

| Ícone | Funcionalidade | Descrição |
| :---: | :--- | :--- |
| 📦 | **Controle de Ferramentas** | Cadastro, listagem e gestão do inventário de ferramentas. |
| ➡️ ⬅️ | **Registro de Movimentações** | Registro rápido de entradas (adição ao estoque) e saídas (retirada para uso). |
| ↩️ | **Devolução** | Vincula uma devolução à movimentação de saída original, facilitando a rastreabilidade. |
| 📜 | **Histórico Completo** | Visualização detalhada de todas as movimentações realizadas. |
| 📄 | **Exportação de Relatórios** | Geração e download de relatórios de movimentação em formato PDF. |

---

## ⚙️ Tecnologias Utilizadas

O projeto é construído em uma arquitetura de microsserviços/API REST, sendo esta a aplicação cliente.

| Categoria | Tecnologia | Versão Principal |
| :---: | :---: | :---: |
| **Frontend** | Angular | 20 |
| **Linguagem (Frontend)** | TypeScript | |
| **Estilização** | Angular Material | |
| **Gestão de Estado**| RxJS (Observables) | |
| **Relatórios** | jsPDF | |
| **Backend Framework** | **Spring Boot** | |
| **Backend Linguagem** | **Java** | **21** |
| **Persistência** | **Spring Data JPA** | |
| **Validação** | **Spring Validation** | |
| **Banco de Dados** | **PostgreSQL** | |

***Necessário ter o repositório [Nome do seu repositório Backend] rodando na porta 8080.***

---

##  Como Executar o Projeto Localmente

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas na sua máquina:

* [**Node.js**](https://nodejs.org/): Versão 18+
* **npm** (instalado com o Node.js) ou **Yarn**
* [**Angular CLI**](https://angular.io/cli)
* **JDK (Java Development Kit) 21** (necessário para rodar o Backend)
* **PostgreSQL** (ou Docker com PostgreSQL) configurado para o Backend
* **Acesso ao Backend** (API REST rodando em `http://localhost:8080/api/movimentacoes`)





## 🤝 Contribuições

Sinta-se à vontade para sugerir melhorias, reportar bugs ou contribuir com o código.

---

