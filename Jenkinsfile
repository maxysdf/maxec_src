pipeline {
    agent any
    stages {

        stage ('Initialize') {
            steps {
                bat '''
                    echo "PATH = %PATH%"
                    echo "M2_HOME = %M2_HOME%"
                ''' 
            }
        }
        
        stage('Build') {
            steps {
                ws("${pwd()}/maxec-parent") {
                    withMaven(
                        maven: 'maven-3.5.4',
                        jdk: 'jdk8'
                    ) {
                        bat 'mvn clean package'
                    }
                }
            }
        }
        
        stage('Docker') {
            steps {
                echo "env branch: ${env.BRANCH_NAME}"
                script {
                    docker.withRegistry('http://localhost:5000') {
                        def img = docker.build("maxec-app-frontend-test:${env.BUILD_ID}", "-f Dockerfile .")
                        img.push()
                    }
                    
                }
                
            }
        
        }
        
        stage('Kubernetes') {
            steps {
                kubernetesDeploy(
                    kubeconfigId: 'k8s',
                    configs: 'k8s/maxec-app-frontend.yml'
                )
            
            }
        
        }
        
    }
}