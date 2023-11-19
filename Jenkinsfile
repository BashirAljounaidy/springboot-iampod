pipeline {
    agent any

    environment {
        ARGOCD_URL = "https://138.68.75.70:31452"
        JWT_TOKEN = credentials('ArgoCd')
        GIT_REPO_URL = "https://github.com/BashirAljounaidy/springboot-iampod.git"
        APP_DEFINITION_FILE = "mainfests/argocd.yml"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the code'
                git branch: 'main', url: GIT_REPO_URL
            }
        }

        stage('Build and Test') {
            steps {
                echo 'Building and testing the project'
                sh 'ls -ltr'
                sh 'mvn clean package -U'
            }
        }

        stage('Static Code Analysis') {
            environment {
                SONAR_URL = "http://138.68.66.18:9000"
            }
            steps {
                withCredentials([string(credentialsId: 'sonarqube', variable: 'SONAR_AUTH_TOKEN')]) {
                    sh 'mvn sonar:sonar -Dsonar.login=$SONAR_AUTH_TOKEN -Dsonar.host.url=${SONAR_URL}'
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    withDockerRegistry([credentialsId: 'docker-cred', url: 'https://index.docker.io/v1/']) {
                        def dockerImage = docker.build("bashiraljounaidy/springboot-iampod:latest", ".")
                        dockerImage.push()
                    }
                }
            }
        }

        stage('Delete ArgoCD Application') {
            steps {
                script {
                    // Delete the existing ArgoCD application
                    sh """
                        curl -k -X DELETE \
                            -H 'Content-Type: application/json' \
                            -H 'Authorization: Bearer ${JWT_TOKEN}' \
                            ${ARGOCD_URL}/api/v1/applications/iampod
                    """
                }
            }
        }

        stage('Create ArgoCD Application') {
            steps {
                script {
                    // Use the YAML file from the cloned repository to recreate the ArgoCD application
                    sh """
                        curl -k -X POST \
                            -H 'Content-Type: application/json' \
                            -H 'Authorization: Bearer ${JWT_TOKEN}' \
                            -d @${APP_DEFINITION_FILE} \
                            ${ARGOCD_URL}/api/v1/applications
                    """
                }
            }
        }
    }
}
