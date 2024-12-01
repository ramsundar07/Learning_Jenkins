pipeline {
    agent any
    tools{
        maven 'maven_3_5_0'
        dockerTool 'docker'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ramsundar07/Learning_Jenkins']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t ramsundar07/app .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u ramsundar07 -p ${dockerhubpwd}'

}
                   sh 'docker push ramsundar07/app'
                }
            }
        }
    }
}