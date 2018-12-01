pipeline {
    agent any
    stages {

        stage ('Build') {
            steps {
                sh 'mvn clean install'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }



         stage ('Unit Test') {
                             steps {
                                 sh 'mvn clean test'
                             }
                             post {
                                 success {
                                     junit 'target/surefire-reports/**/*.xml'
                                 }
                             }
          }

          stage ('CodeCoverage') {
                                      steps {
                                          sh 'mvn clean test jacoco:report'
                                      }
                                      post {
                                          success {
                                              jacoco 'target/site/**/*.xml'
                                          }
                                      }
           }
    }
}