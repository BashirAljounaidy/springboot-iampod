pipeline {
  agent any
  environment {
        ARGOCD_URL = "https://138.68.75.70:31452"
        APPLICATION_NAME = "iampod"
        JWT_TOKEN = credentials('ArgoCd')
        version = "v12"
  }
  stages {
    stage('Checkout') {
      steps {
        echo 'Checking out the code'
        git branch: 'main', url: 'https://github.com/BashirAljounaidy/springboot-iampod'
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
            def dockerImage = docker.build("bashiraljounaidy/springboot-iampod:${version}", ".")
            dockerImage.push()
          }
        }
      }
    }
    stage('Trigger ArgoCD Sync') {
        steps {
            script {
                def syncPayload = '{"prune": true, "dryRun": false, "force": true}'
                sh(script: "curl -k -X POST -H 'Content-Type: application/json' -H 'Authorization: Bearer ${JWT_TOKEN}' -d '${syncPayload}' ${ARGOCD_URL}/api/v1/applications/${APPLICATION_NAME}/sync", returnStatus: true)
            }
        }
    }
  }
}
