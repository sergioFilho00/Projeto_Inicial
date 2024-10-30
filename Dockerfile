FROM maven:3.8.5-openjdk-8-slim AS build

# Copiar o pom.xml e o código fonte
COPY pom.xml /app/
COPY src /app/src/

WORKDIR /app

# Compilar o projeto (isso também baixa as dependências)
RUN mvn clean test

# Etapa final
FROM openjdk:8-jdk-alpine
COPY --from=build /app/target/*.jar /app/ProjetoInicial.jar

# Comando padrão para executar o JAR
CMD ["mvn", "test"]

