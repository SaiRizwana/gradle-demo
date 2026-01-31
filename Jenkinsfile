pipeline{
    agent any

    stages{
       stage('Checkout'){
          steps{
              git branch: 'main',
                  url: 'https://github.com/SaiRizwana/gradle-demo.git'
          }
       }
     
       stage('Build & Test(Gradle)'){
           steps{
               sh './gradle clean build test'
           }
       }

       stage('Archive Artifact'){
           steps{
               archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint:true
           }
       }
    }
}
