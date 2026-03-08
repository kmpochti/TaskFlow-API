# 1. Ποια έκδοση Java θα χρησιμοποιήσουμε
FROM eclipse-temurin:17-jdk-alpine

# 2. Πού θα "κάθεται" η εφαρμογή μέσα στο Docker
WORKDIR /app

# 3. Ποιο αρχείο θα τρέξει (το .jar που παράγει το Gradle)
COPY build/libs/*.jar app.jar

# 4. Πώς θα ξεκινάει η εφαρμογή
ENTRYPOINT ["java", "-jar", "app.jar"]