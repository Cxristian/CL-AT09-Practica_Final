pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Building...'
        sh 'chmod +x ./sampleWebApp/gradlew'
        sh './sampleWebApp/gradlew assemble -p sampleWebApp/'
        archiveArtifacts 'sampleWebApp/build/libs/*.jar'
      }
    }
    stage('Unit Test') {
      steps {
        echo 'Unit Test...'
        sh './sampleWebApp/gradlew test -p sampleWebApp/'
      }
    }
    stage('Check') {
      steps {
        echo 'Checking'
        sh './sampleWebApp/gradlew check -p sampleWebApp/'
      }
    }
    stage('Sonarqube..') {
      steps {
        echo 'Sonarqube'
        sh './sampleWebApp/gradlew sonarqube -p sampleWebApp/'
      }
    }
  }
  post {
    always {
      echo 'This is a post action.'
        mail to: 'Cristian.lujan@fundacion-jala.org',
          subject: "Test Pipeline: ${currentBuild.fullDisplayName}",
          body: "The pipeline ${currentBuild.fullDisplayName} completed successfully."
    }
  }
}