pipeline {
    agent any
    tools {
        maven 'maven_3_5_0'  // Your Maven tool configuration
        dockerTool 'docker'  // Docker tool configuration (if needed)
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ramsundar07/Learning_Jenkins']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image') {
            steps {
                script {
                    sh 'docker build -t ramsundar07/app .'
                }
            }
        }
        stage('Push image to Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u ramsundar07 -p ${dockerhubpwd}'
                    }
                    sh 'docker push ramsundar07/app'
                }
            }
        }
        stage('Deploy to k8s') {
            steps {
                script {
                    // Run the kubectl apply command inside the Docker container that has kubectl
                    docker.image('bitnami/kubectl:latest').inside {
                        withKubeConfig([credentialsId: 'k8sconfigpwd']) {
                            sh 'kubectl apply -f deploymentservice.yaml'
                        }
                    }
                }
            }
        }
    }
}
