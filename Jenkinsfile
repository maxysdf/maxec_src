pipeline {
    agent any
    environment {
        branch = env.BRANCH_NAME.toLowerCase()
    }
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
                    script {
                        def img = docker.build("maxec-app-frontend-${env.branch}:${env.BUILD_ID}", "-f Dockerfile .")
                    }
                }
            }
        
        }
        
    }
}