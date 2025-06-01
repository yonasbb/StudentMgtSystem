pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6' // Adjust to match Jenkins global tool config
        jdk 'JDK 11'        // Or 'JDK 17' if using Java 17
    }

    environment {
        // Define environment variables if needed
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/yonasbb/StudentMgtSystem.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
