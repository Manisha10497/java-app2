pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        IMAGE_NAME = "yourdockerhub/java-app"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/Manisha10497/java-app.git'
            }
        }

        stage('Build Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME:${BUILD_NUMBER} .'
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub',
                usernameVariable: 'USERNAME',
                passwordVariable: 'PASSWORD')]) {

                    sh 'docker login -u $USERNAME -p $PASSWORD'
                    sh 'docker push $IMAGE_NAME:${BUILD_NUMBER}'
                }
            }
        }

        stage('Deploy Container') {
            steps {
                sh '''
                docker stop java-app || true
                docker rm java-app || true
                docker run -d -p 8081:8080 --name java-app $IMAGE_NAME:${BUILD_NUMBER}
                '''
            }
        }

    }
}
