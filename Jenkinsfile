pipeline {
    agent any
    options {
        parallelsAlwaysFailFast()
    }
    environment {
        BRANCH = "${GIT_BRANCH}"
        DOCKER_BRANCH = "${GIT_BRANCH.replaceFirst(/.*\//,'')}"
        DOCKER_RESP = 'host.docker.internal:5000';
    }
    
    stages {
        
        stage('Build - app') {
            steps {
                ws("${pwd()}/maxec-parent") {
                    withMaven(
                        maven: 'maven-3.5.4',
                        jdk: 'jdk8'
                    ) {
                        bat 'mvn -P prod -Dmaven.test.skip=true clean package'
                    }
                }
            }
        }
        
        stage('Docker Clear') {
            steps {
                script {
                    bat """
                        docker container prune -f
                        docker image prune -a -f
                    """
                }
            }
        }
        
        stage('Docker') {
            parallel {
                stage('Docker - db') {
                    steps {
                        echo "env branch: ${env.BRANCH}"
                        script {
                            def proj = 'maxec-db';
                            def dockerfile = 'DockerfileDB';
                            docker.withRegistry("http://${env.DOCKER_RESP}") {
                                def img = docker.build("${env.DOCKER_RESP}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}", "-f ${dockerfile} .")
                                img.push()
                            }
                        }
                    }
                }
            
                stage('Docker - app frontend') {
                    steps {
                        echo "env branch: ${env.BRANCH}"
                        script {
                            def proj = 'maxec-app-frontend';
                            def dockerfile = 'DockerfileAppFront';
                            docker.withRegistry("http://${env.DOCKER_RESP}") {
                                def img = docker.build("${env.DOCKER_RESP}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}", "-f ${dockerfile} .")
                                img.push()
                            }
                        }
                    }
                }
                
                stage('Docker - app backend') {
                    steps {
                        echo "env branch: ${env.BRANCH}"
                        script {
                            def proj = 'maxec-app-backend';
                            def dockerfile = 'DockerfileAppBack';
                            docker.withRegistry("http://${env.DOCKER_RESP}") {
                                def img = docker.build("${env.DOCKER_RESP}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}", "-f ${dockerfile} .")
                                img.push()
                            }
                        }
                        
                    }
                }
                
                stage('Docker - web backend') {
                    steps {
                        echo "env branch: ${env.BRANCH}"
                        script {
                            def proj = 'maxec-web-backend';
                            def dockerfile = 'DockerfileWebBack';
                            docker.withRegistry("http://${env.DOCKER_RESP}") {
                                def img = docker.build("${env.DOCKER_RESP}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}", "-f ${dockerfile} .")
                                img.push()
                            }
                        }
                        
                    }
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
                            ymlAppBcks[1].spec.template.spec.containers[0].image = "${env.DOCKER_RESP}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}"

                            dir('k8s_dep') {
                                writeYaml file: "${proj}-service.yml"    , data: ymlAppBcks[0], overwrite: true
                                writeYaml file: "${proj}-statefulset.yml", data: ymlAppBcks[1], overwrite: true
                                bat """
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
                            ymlAppBcks[1].spec.template.spec.containers[0].image = "${env.DOCKER_RESP}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}"
                            
                            dir('k8s_dep') {
                                writeYaml file: "${proj}-service.yml"   , data: ymlAppBcks[0], overwrite: true
                                writeYaml file: "${proj}-deployment.yml", data: ymlAppBcks[1], overwrite: true
                                bat """
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
                            ymlAppBcks[1].spec.template.spec.containers[0].image = "${env.DOCKER_RESP}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}"
                            
                            dir('k8s_dep') {
                                writeYaml file: "${proj}-service.yml"   , data: ymlAppBcks[0], overwrite: true
                                writeYaml file: "${proj}-deployment.yml", data: ymlAppBcks[1], overwrite: true
                                bat """
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
                            ymlAppBcks[1].spec.template.spec.containers[0].image = "${env.DOCKER_RESP}/${proj}:${env.DOCKER_BRANCH}-${env.BUILD_ID}"
                            
                            dir('k8s_dep') {
                                writeYaml file: "${proj}-service.yml"   , data: ymlAppBcks[0], overwrite: true
                                writeYaml file: "${proj}-deployment.yml", data: ymlAppBcks[1], overwrite: true
                                bat """
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