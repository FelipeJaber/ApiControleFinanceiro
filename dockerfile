# Use uma imagem base apropriada (exemplo: OpenJDK)
FROM openjdk:21-jdk-slim

# Instale o Git
RUN apt-get update && apt-get install -y git maven

# Defina o diretório de trabalho
WORKDIR /app

# Clone o repositório
RUN git clone https://github.com/FelipeJaber/ApiControleFinanceiro .

# Compile o projeto
RUN mvn clean install

# Comando para rodar a aplicação (ajuste conforme necessário)
CMD ["java", "-jar", "target/ApiControleFinanceiro-0.0.1-SNAPSHOT.jar"]
