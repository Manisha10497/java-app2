pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Build Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t java-app2 .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d -p 8082:8081 java-app2'
            }
        }

    }
}
