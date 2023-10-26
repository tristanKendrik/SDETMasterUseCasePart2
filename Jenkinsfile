pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // This step checks out your source code from the Git repository
                script {
                    // Assuming your Git repository URL is "https://github.com/yourusername/yourrepository.git"
                    checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/tristanKendrik/SDETMasterUseCasePart2.git']]])
                }
            }
        }
        
        stage('Build') {
            steps {
                // This step builds the Maven project
                bat 'mvn clean install'
            }
        }
        
        stage('Test') {
            steps {
                // This step executes the TestNG tests
                bat 'mvn test'
            }
        }
        
        // Add more stages as needed (e.g., deployment, etc.)
    }
    
    post {
        always {
            // This block of code will be executed after all stages, regardless of success or failure
            echo 'Pipeline completed'
        }
    }
}
