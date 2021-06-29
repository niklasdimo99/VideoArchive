pipeline {
    
  agent any
    tools {
        gradle 'Gradle-7.1'
    }
  
  
  
    
    stages {
       
        stage("run backend") {
            steps {
                echo 'executing gradle...'
                withGradle() {
                    sh './gradlew -v'
                }
            }
        }
        
        stage("build") {
            steps {
                echo 'building the application'
                
                
            }
        }
        stage("test") {
            steps {
                echo 'testin the application'
            }
        }
        stage("deploy") {
            steps {
                sh 'docker run -d -p 8080:8080
            }
        
       }
      
      
}












