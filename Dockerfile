FROM amazoncorretto:17-alpine

WORKDIR /app

# Copiando o arquivo pom.xml para a pasta atual
COPY pom.xml .

# Instalando as dependências do Maven
RUN apk add --no-cache maven && mvn dependency:go-offline

# Copiando o código-fonte para a pasta atual
COPY src ./src

# Construindo o projeto e criando a pasta target
RUN mvn package -DskipTests

CMD ["java", "-jar", "target/hackaton-0.0.1-SNAPSHOT.jar"]


