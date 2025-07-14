pipeline {
    agent any
    stages {
        stage('Build Backend') {
            steps {
                sh 'cd backend && ./mvnw clean package'
            }
        }
        stage('Build Frontend') {
            steps {
                sh 'cd frontend && npm install && npm run build'
            }
        }
        stage('Docker Build & Deploy') {
            steps {
                sh 'docker-compose up -d --build'
            }
        }
    }
}
