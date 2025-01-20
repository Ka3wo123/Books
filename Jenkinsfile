pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk'
        MAVEN_HOME = '/opt/maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Ka3wo123/Books.git'
            }
        }

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

    post {
        always {
            echo 'Pipeline completed'
        }
        success {
            echo 'Build and deployment successful'
        }
        failure {
            echo 'Build or deployment failed'
        }
    }
}
