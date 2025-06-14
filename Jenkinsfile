pipeline {
    agent any

    tools {
        maven 'Maven' // Adjust to match Jenkins global tool config
        jdk 'JDK 21'        // Or 'JDK 17' if using Java 17
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',  git 'https://github.com/yonasbb/StudentMgtSystem.git'
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
