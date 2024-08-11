pipeline {
    agent any
    environment {
        APP_NAME = "myapp"
    }

    stages {
        stage('Build or Use Existing Docker Image') {
            steps {
                script {
                    def imageExists = sh (
                            script: "docker images -q ${APP_NAME}:${TAG}",
                            returnStdout: true
                    ).trim()

                    if (imageExists) {
                        echo "Docker image ${APP_NAME}:${TAG} already exists. Skipping build."
                    } else {
                        echo "Docker image ${APP_NAME}:${TAG} does not exist. Building the image."
                        sh "docker build --no-cache -t  ${APP_NAME}:${TAG} -f domestic/Dockerfile ."
                    }
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
                        docker run -d --name ${APP_NAME} -p 8081:8081 ${APP_NAME}:${TAG}
                    """
                }
            }
        }
    }
}