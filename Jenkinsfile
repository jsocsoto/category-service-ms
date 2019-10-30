node {
  try {
    stage('SCM Checkout') {
      git(
         url: 'https://github.com/jsocsoto/category-service-ms',
         credentialsId: '7e130adc-2841-4cab-9b55-ffaad84f7196',
         branch: 'master'
      )
    }
    stage('Compile-Package') {
      sh 'mvn clean install'
    }
    stage('Deploy-Package') {
      sh 'mvn tomcat7:redeploy'
    }
    stage('Email-Notification') {
      mail bcc: '', body: 'The application category-service-ms was deploy successfully.', cc: '', from: '', replyTo: '', subject: 'category-service-ms pipeline', to: 'jsocsoto@gmail.com'      
    }
  } catch (err) {
    currentBuild.result = 'FAILURE'
    throw any //rethrow exception to prevent the build from proceeding
  } finally {
    step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'jsocsoto@gmail.com', sendToIndividuals: true])
  }
}