node {
  stage('SCM Checkout') {
    git 'https://github.com/jsocsoto/category-service-ms'
  }
  stage('Compile-Package') {
    bat 'mvn clean install'
  }
  stage('Deploy-Package') {
    bat 'mvn tomcat7:redeploy'
  }
}
