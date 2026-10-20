# 📚 BookStore DevSecops


Sistema de gerenciamento de livros desenvolvido com Java Spring Boot, utilizando práticas modernas de DevOps, Observabilidade e Monitoramento.

O projeto demonstra a implementação completa de:

    Conteinerização com Docker
    Multistage Build 
    Integração Contínua (CI)
    Entrega Contínua (CD)
    Monitoramento com Prometheus
    Observabilidade com Grafana
    Centralização de Logs com Graylog
    Publicação automatizada de imagens Docker


# 📌 Objetivo
Desenvolver uma aplicação SpringBoot, implementando uma infraestrutura completa de monitoramento, observabilidade, centralização de logs e automação CI/CD.

🏗 Arquitetura da Solução
                     GitHub Actions
                            │
                            ▼
                       Docker Hub
                            │
                            ▼

                     BookStore API
                      Spring Boot
                            │
         ┌──────────────────┴──────────────────┐
         │                                     │
         ▼                                     ▼

    Prometheus                           Graylog
         │                                     │
         ▼                                     ▼

      Grafana                           OpenSearch
                                               │
                                               ▼
                                           MongoDB
# 📋 Pré-requisitos:<br>
    Antes de executar o projeto, certifique-se de possuir os seguintes softwares instalados:
    Docker
    docker --version
    Docker Compose
    docker compose version
    Git
    git --version

# 🔌Portas Utilizadas
      API Spring Boot 8080
      Prometheus	9090
      Grafana	3000
      Graylog	9000
      OpenSearch	9200
      GELF UDP	12201
  
# 🛠 Tecnologias Utilizadas:
    Java 21
    Spring Boot
    Maven
    Docker
    Docker Compose
    Prometheus
    Grafana
    Graylog
    MongoDB
    OpenSearch
    GitHub Actions
    Docker Hub
    
# 📦Dockerfile Multistage Build
O projeto utiliza Dockerfile Multistage Build, conforme exigido pela atividade.

## Estágio de Build

FROM maven:3.9-eclipse-temurin-21 AS build
Responsável por:

    Download das dependências
    Compilação da aplicação
    Geração do JAR
    
  ## Estágio de Runtime
  
  FROM eclipse-temurin:21-jre
  Responsável por:

    Execução da aplicação
    Redução do tamanho da imagem
    Ambiente de produção mais enxuto
  # 🚀Como Executar o Projeto:
    git clone https://github.com/domingosunoesc/Devsecops.git
    cd Devsecops
    
  ## Subir Toda a Infraestrutura
  docker compose up --build
  
  Esse comando irá iniciar:

    BookStore API
    Prometheus
    Grafana
    Graylog
    MongoDB
    OpenSearch
✅ Verificação da Instalação
Verifique os containers:

    docker compose ps<br>
Resultado esperado:

    devsecops-app
    devsecops-prometheus
    devsecops-grafana
    devsecops-graylog
    devsecops-mongodb
    devsecops-opensearch
Todos os serviços devem aparecer com status:
Up


# 🌐 Acesso aos Serviços
  
Aplicação<br>
http://localhost:8080<br>
Prometheus<br>
http://localhost:9090<br>
Grafana<br>
http://localhost:3000<br>


# 🐳 Docker Hub

A imagem é publicada automaticamente pela pipeline.

![evidencias do docker hub](docs/dockhub.png)


# 🔄 GitHub Actions


![](docs/github-actions.png)

# 📡 Prometheus



![evidencias do prometheus](docs/prometheus.png)



# 📊 Grafana



![evidencias do grafana](docs/grafana.png)



# 📋 Graylog



![evidencias do graylog](docs/graylog.png)


# 👨‍💻 Autor
Benvindo Domingos Ngola dos Santos

    GitHub
   https://github.com/domingosunoesc

    Docker Hub
   https://hub.docker.com/r/benvindosantos/devsecops
