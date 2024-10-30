FROM maven:3.8.5-openjdk-8-slim AS build

# Copiar o pom.xml e o código fonte
COPY pom.xml /app/
COPY src /app/src/

WORKDIR /app

# Compilar o projeto (isso também baixa as dependências)
RUN mvn clean package

# Etapa final
FROM openjdk:8-jdk-alpine

# Copiar o JAR gerado da etapa de construção
COPY --from=build /app/target/ProjetoInicial-1.0-SNAPSHOT.jar /app/ProjetoInicial.jar

# Comando padrão para executar o JAR
CMD ["java", "-cp", "/app/ProjetoInicial.jar", "Main"]
