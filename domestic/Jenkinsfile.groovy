pipeline {
    agent any
    environment {
        APP_NAME = "myapp"
    }

    stages {
        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${APP_NAME}:${TAG} ."
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    sh """
                          docker stop ${APP_NAME} || true
                          docker rm ${APP_NAME} || true
                        """

                    sh """
                          docker run -d --name ${APP_NAME} -p 8080:8080 ${APP_NAME}:${TAG}
                        """
                }
            }
        }

    }
}