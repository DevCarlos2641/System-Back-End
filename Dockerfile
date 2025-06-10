# Etapa de construcción
FROM eclipse-temurin:21-jdk-alpine AS builder

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar archivos de construcción (Gradle/Maven wrapper + configuración + código)
COPY . .

# Si usas Maven:
# RUN ./mvnw clean package -DskipTests

# Si usas Gradle con Kotlin DSL:
RUN ./gradlew clean bootJar -x test

# Etapa final: usar una imagen liviana
FROM eclipse-temurin:21-jre-alpine

# Crear un usuario no root por seguridad
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Crear directorio para la app
WORKDIR /app

# Copiar solo el artefacto generado
COPY --from=builder /app/build/libs/*.jar app.jar

# Puerto en el que corre tu app
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
