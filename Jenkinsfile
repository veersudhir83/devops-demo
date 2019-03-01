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
     sh script: 'curl -uadmin:AP5n2xWHNccv2Ea7VJXFK9j4UHW -T ${WORKSPACE}/target/*.jar http://localhost:8081/artifactory/generic-local/devops-demo/DEV_ENV/${BUILD_NUMBER}/'
   }
   
   stage('Download Artifact') {
      dir('../../userContent/') {
          sh script: 'curl -uadmin:AP5n2xWHNccv2Ea7VJXFK9j4UHW -O http://localhost:8081/artifactory/generic-local/devops-demo/DEV_ENV/${BUILD_NUMBER}/devops-demo-app-0.0.1-SNAPSHOT.jar'
      }
      sh script: 'curl -uadmin:AP5n2xWHNccv2Ea7VJXFK9j4UHW -O http://localhost:8081/artifactory/generic-local/devops-demo/DEV_ENV/${BUILD_NUMBER}/devops-demo-app-0.0.1-SNAPSHOT.jar'
   }   
}
