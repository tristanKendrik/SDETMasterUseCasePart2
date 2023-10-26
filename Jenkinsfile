pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/tristanKendrik/SDETMasterUseCasePart2.git']]])
                }
            }
        }
        
        stage('Build') {
            steps {
                dir('MUCP2') { // Specify the directory containing pom.xml
                    bat 'mvn clean install'
                }
            }
        }
        
        stage('Test') {
            steps {
                dir('MUCP2') { // Specify the directory containing pom.xml
                    bat 'mvn test'
                }
            }
        }
        
        // Add more stages as needed (e.g., deployment, etc.)
    }
    
    post {
        always {
            echo 'Pipeline completed'
        }
    }
}
