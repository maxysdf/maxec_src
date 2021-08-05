pipeline {
    agent any
    stages {
        environment {
            branch = env.BRANCH_NAME.toLowerCase()
        }
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
                echo('start building...')
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
                ws("${pwd()}/maxec-parent") {
                    def img = docker.build("maxec-app-frontend-${branch}:${env.BUILD_ID}", "-f Dockerfile .")
            }
        
        }
        
    }
}