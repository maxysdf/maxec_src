pipeline {
    agent any
    options {
        parallelsAlwaysFailFast()
    }
    environment {
        BRANCH = "${GIT_BRANCH}"
        DOCKER_BRANCH = "${GIT_BRANCH.replaceFirst(/.*\//,'')}"
        DOCKER_RESP = 'maxhome:5080';
        DOCKER_PROJ = 'jenkins'
    }
    
    stages {
        
        stage('Build - app') {
            steps {
                ws("${pwd()}/maxec-parent") {
                    withMaven(maven: 'maven-3.5.4', jdk: 'jdk8') {
                        sh 'mvn -P prod -Dmaven.test.skip=true clean package'
                    }
                }
            }
        }
        
        stage('Docker Clear') {
            steps {
                script {
                    sh """
                        docker container prune -f
                        docker image prune -a -f
                    """
                }
            }
        }
        
        stage('Docker') {
            parallel {
                stage('Docker - web frontend') {
                    steps { script { buildAndPushImage('maxec-web-frontend') } }
                }
                stage('Docker - web backend') {
                    steps { script { buildAndPushImage('maxec-web-backend') } }
                }
                stage('Docker - app') {
                    steps { 
                        script { buildAndPushImage('maxec-app-frontend') } 
                        script { buildAndPushImage('maxec-app-backend' ) }
                        script { buildAndPushImage('maxec-app-job'     ) }
                        script { buildAndPushImage('maxec-biz-product' ) }
                        script { buildAndPushImage('maxec-biz-search'  ) }
                        script { buildAndPushImage('maxec-biz-shopping') }
                        script { buildAndPushImage('maxec-biz-content' ) }
                        script { buildAndPushImage('maxec-biz-customer') }
                    }
                }
                stage('Docker - db') {
                    steps { script { buildAndPushImage('maxec-db') } }
                }
                stage('Docker - es') {
                    steps { script { buildAndPushImage('maxec-es') } }
                }
            }
        }
        
        stage ('Kubernetes') {
            parallel {
                stage ('Kubernetes - db') {
                    steps { script { deployDBOnK8S('maxec-db'); } }
                }
                
                stage ('Kubernetes - es') {
                    steps { script { deployDBOnK8S('maxec-es'); } }
                }
                
                stage ('Kubernetes - biz') {
                    steps { 
                        script { 
                            deployAppWebBizOnK8S('maxec-biz-product' );
                            deployAppWebBizOnK8S('maxec-biz-search'  );
                            deployAppWebBizOnK8S('maxec-biz-shopping');
                            deployAppWebBizOnK8S('maxec-biz-content' );
                            deployAppWebBizOnK8S('maxec-biz-customer');
                        } 
                    }
                }
                
                
                stage ('Kubernetes - app') {
                    steps { 
                        script { 
                            deployAppWebBizOnK8S('maxec-app-frontend'); 
                            deployAppWebBizOnK8S('maxec-app-backend'); 
                            deployJobOnK8S('maxec-app-job'); 
                        } 
                    }
                }
            
                stage ('Kubernetes - web') {
                    steps { 
                        script { 
                            deployAppWebBizOnK8S('maxec-web-frontend');
                            deployAppWebBizOnK8S('maxec-web-backend');
                        } 
                    }
                }
            }
        }
    }
}


def buildAndPushImage(String proj) {
    script {
        docker.withRegistry("http://${env.DOCKER_RESP}", 'harbor') {
            def img = docker.build("${env.DOCKER_RESP}/${env.DOCKER_PROJ}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}", "--network host ${proj}")
            img.push()
        }
    }
}

def deployDBOnK8S(String proj) {
    def ymlAppBcks = readYaml file: "k8s/${proj}.yml"
    ymlAppBcks[1].spec.template.spec.containers[0].image = "${env.DOCKER_RESP}/${env.DOCKER_PROJ}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}"

    dir('k8s_dep') {
        writeYaml file: "${proj}-service.yml"    , data: ymlAppBcks[0], overwrite: true
        writeYaml file: "${proj}-statefulset.yml", data: ymlAppBcks[1], overwrite: true
        sh """
            kubectl apply -f ${proj}-service.yml
            kubectl apply -f ${proj}-statefulset.yml
        """
    }
}

def deployAppWebBizOnK8S(String proj) {
    def ymlAppBcks = readYaml file: "k8s/${proj}.yml"
    ymlAppBcks[1].spec.template.spec.containers[0].image = "${env.DOCKER_RESP}/${env.DOCKER_PROJ}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}"
    
    dir('k8s_dep') {
        writeYaml file: "${proj}-service.yml"   , data: ymlAppBcks[0], overwrite: true
        writeYaml file: "${proj}-deployment.yml", data: ymlAppBcks[1], overwrite: true
        sh """
            kubectl apply -f ${proj}-service.yml
            kubectl apply -f ${proj}-deployment.yml
        """
    }
}

def deployJobOnK8S(String proj) {
    def ymlAppBcks = readYaml file: "k8s/${proj}.yml"
    ymlAppBcks.spec.template.spec.containers[0].image = "${env.DOCKER_RESP}/${env.DOCKER_PROJ}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}"
    
    dir('k8s_dep') {
        writeYaml file: "${proj}-deployment.yml", data: ymlAppBcks, overwrite: true
        sh """
            kubectl apply -f ${proj}-deployment.yml
        """
    }
}
