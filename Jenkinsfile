pipeline{
    agent any

    tools{
        jdk 'jdk17'
    }

    stages{
       stage('Checkout'){
          steps{
              git branch: 'main',
                  url: 'https://github.com/SaiRizwana/gradle-demo.git'
          }
       }
     
       stage('Build & Test(Gradle)'){
           steps{
               sh './gradlew clean build test'
           }
       }

       stage('SonarQube Analysis'){
          steps{
              withSonarQubeEnv('SonarQube'){
                  sh '''
                  ./gradlew sonar \
                  -Dsonar.projectKey=gradle-demo \
                  -Dsonar.projectName=gradle-demo \
                  -Dsonar.java.binaries=build \
                  -Dsonar.coverage.jacoco.xmlReportsPaths=build/reports/jacoco/test/jacocoTestReport.xml
                  '''
              }
          }
       }

       stage('Archive Artifact'){
           steps{
               archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint:true
           }
       }
    }
}
