pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                echo 'Compiling..'
                withMaven(maven : "maven_3.8.1") {
                    sh "mvn clean compile"
                }
                sh "npm install"
            }

        }

        stage('UnitTest') {
            steps {
                echo 'Running unit tests...'
                withMaven(maven : "maven_3.8.1") {
                    sh "mvn clean install"
                }
            }
        }

        stage('FunctionalityTest') {
            parallel {
                stage('Starting spring app...') {
                    steps {
                        sh "java -jar target/jenkins-full-cycle-demo-0.0.1-SNAPSHOT.jar"
                    }
                }
                stage('Running tests...') {
                    steps {
                        sleep(time:15, unit:"SECONDS")
                        script {
                            try {
                                sh "npm test"
                                currentBuild.result = "SUCCESS"
                            } catch(Exception e) {
                                currentBuild.result = "FAILURE"
                            }
                        }
                    }
                }
            }
        }
    }
}