# Usar uma imagem base com Java 17 (ou versão compatível com o Spring Boot)
FROM eclipse-temurin:17-jdk-alpine

# Diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Spring Boot
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que o Spring Boot utiliza
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
