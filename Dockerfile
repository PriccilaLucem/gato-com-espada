FROM maven:3.8.5-openjdk-17

# Defina o diretório de trabalho
WORKDIR /app

# Copie o script wait-for-it.sh para o contêiner
COPY wait-for-it.sh /app/wait-for-it.sh

# Torne o script executável
RUN chmod +x /app/wait-for-it.sh

# Copie o código da aplicação para dentro do contêiner
COPY . .

# Execute o Maven para compilar a aplicação
RUN mvn clean install

# Use wait-for-it.sh para aguardar o MongoDB antes de iniciar a aplicação

ENTRYPOINT ["/app/wait-for-it.sh", "mongodb:27017", "--", "java", "-jar", "/app/target/springboot-app.jar"]