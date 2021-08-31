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
            steps {
                echo 'Running functionality tests...'
                parallel(
                      serverStart: {
                        sh "java -jar target/jenkins-full-cycle-demo-0.0.1-SNAPSHOT.jar"
                      },
                      npmTest: {
                        sleep(time:15, unit:"SECONDS")
                        sh "npm test"
                      }
                    )
            }
        }
    }
}