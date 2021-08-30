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
                        script { buildAndPushImage('maxec-biz-product' ) }
                        script { buildAndPushImage('maxec-biz-search'  ) }
                        script { buildAndPushImage('maxec-biz-shopping') }
                        script { buildAndPushImage('maxec-biz-content' ) }
                    }
                }
                stage('Docker - db') {
                    steps { script { buildAndPushImage('maxec-db') } }
                }
            }
        }
        
        stage ('Kubernetes') {
            parallel {
                stage ('Kubernetes - db') {
                    steps {
                        script {
                            def proj = 'maxec-db'
                            def ymlAppBcks = readYaml file: "k8s/${proj}.yml"
                            ymlAppBcks[1].spec.template.spec.containers[0].image = "${env.DOCKER_RESP}/${DOCKER_PROJ}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}"

                            dir('k8s_dep') {
                                writeYaml file: "${proj}-service.yml"    , data: ymlAppBcks[0], overwrite: true
                                writeYaml file: "${proj}-statefulset.yml", data: ymlAppBcks[1], overwrite: true
                                sh """
                                    kubectl apply -f ${proj}-service.yml
                                    kubectl apply -f ${proj}-statefulset.yml
                                """
                            }
                        }
                    }
                }
                
                stage ('Kubernetes - app frontend') {
                    steps {
                        script {
                            def proj = 'maxec-app-frontend'
                            def ymlAppBcks = readYaml file: "k8s/${proj}.yml"
                            ymlAppBcks[1].spec.template.spec.containers[0].image = "${env.DOCKER_RESP}/${DOCKER_PROJ}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}"
                            
                            dir('k8s_dep') {
                                writeYaml file: "${proj}-service.yml"   , data: ymlAppBcks[0], overwrite: true
                                writeYaml file: "${proj}-deployment.yml", data: ymlAppBcks[1], overwrite: true
                                sh """
                                    kubectl apply -f ${proj}-service.yml
                                    kubectl apply -f ${proj}-deployment.yml
                                """
                            }
                        }
                    }
                }
            
                stage ('Kubernetes - app backend') {
                    steps {
                        script {
                            def proj = 'maxec-app-backend'
                            def ymlAppBcks = readYaml file: "k8s/${proj}.yml"
                            ymlAppBcks[1].spec.template.spec.containers[0].image = "${env.DOCKER_RESP}/${DOCKER_PROJ}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}"
                            
                            dir('k8s_dep') {
                                writeYaml file: "${proj}-service.yml"   , data: ymlAppBcks[0], overwrite: true
                                writeYaml file: "${proj}-deployment.yml", data: ymlAppBcks[1], overwrite: true
                                sh """
                                    kubectl apply -f ${proj}-service.yml
                                    kubectl apply -f ${proj}-deployment.yml
                                """
                            }
                        }
                    }
                }
                
                stage ('Kubernetes - web backend') {
                    steps {
                        script {
                            def proj = 'maxec-web-backend'
                            def ymlAppBcks = readYaml file: "k8s/${proj}.yml"
                            ymlAppBcks[1].spec.template.spec.containers[0].image = "${env.DOCKER_RESP}/${DOCKER_PROJ}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}"
                            
                            dir('k8s_dep') {
                                writeYaml file: "${proj}-service.yml"   , data: ymlAppBcks[0], overwrite: true
                                writeYaml file: "${proj}-deployment.yml", data: ymlAppBcks[1], overwrite: true
                                sh """
                                    kubectl apply -f ${proj}-service.yml
                                    kubectl apply -f ${proj}-deployment.yml
                                """
                            }
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