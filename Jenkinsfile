pipeline {
    agent any
    stages {
        stage('SCM') {
            steps {
                git url: 'https://github.com/dd37-magh-jpg/10037-ddprocessing-currency-converter-service.git'
            }
        }
        stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv('jenkinsSonar') {
                    // Optionally use a Maven environment you've configured already
                    withMaven(maven:'Maven 3.5') {
                        sh 'mvn clean package sonar:sonar'
                    }
                }
            }
        }
        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}
