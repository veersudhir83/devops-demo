node {
   def mvnHome
   stage('Tool Setup') { // for display purposes
      mvnHome = tool 'mvn'
   }

   stage('Checkout') {
      checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/veersudhir83/devops-demo.git']]])
   }

   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" clean package/)
      }
   }

   stage('Upload Artifact') {
     sh "curl -uadmin:APBCtBCDns234HC98JejBsWfu6c -T '${WORKSPACE}/target/*.jar'
     'http://mydevops.io:8081/artifactory/generic-local/devops-demo/${BUILD_NUMBER}'"
   }
}
