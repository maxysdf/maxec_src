pipeline {
    agent any
    tools {
        maven 'maven-3.5.4'
        jdk 'jdk8'
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
            }
        
        
        
        }
    
    }
}