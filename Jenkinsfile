pipeline {
    agent {
        node {
            label 'docker-alpine'
        }
    }
    triggers {
        pollSCM '*/1 * * * *'
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
