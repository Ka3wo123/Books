pipeline {
    agent {
        node {
            label 'docker-alpine'
        }
    }
    triggers {
        poolSCM '*/5 * * * *'
    }

    stages {
        stage('Build') {
            steps {
                script {
                    sh './gradlew build -x test'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh './gradlew test'
                }
            }
        }
    }
}
