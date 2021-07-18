pipeline {
    agent any
    
    environment{
        registry = 'akashbisariya/testjavanew'   
        registryCredential = 'DockerCredential'
        username = 'akashbisariya'
        sonarCredential = credentials('SonarQubeCredential')
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven 'mavenjava'
    }

    options {
        timestamps()
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '20', numToKeepStr: '5')
    }
    stages {
        stage('Checkout'){
            steps{
                git 'https://github.com/akash-bisariya/NagpJavaApp'
            }
        }
        stage('SonarQube Analysis'){
            steps{
                echo "Performing SonarQube Analysis"
                // bat "mvn clean verify sonar:sonar -Dsonar.login=8c8f1f2f4836d5b0021423dc69ecffd09b5ec8f7"   
                bat "mvn clean verify sonar:sonar -Dsonar.login=${sonarCredential}"   
            }
        }
        stage('Build') {
            steps {
                echo "Building the java project"
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        
        stage('Unit-Test') {
            steps {
                    echo "Performing Unit testing"
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
            }
        }
        
        stage('Build Docker Image'){
            steps{
                echo "Building docker image"
                bat "docker build -t i_${username}_master_test --no-cache -f Dockerfile ."
            }
        }
        
        stage('Push Image to DockerHub'){
            steps{
                echo "Pushing the docker image to docker hub"
                bat "docker tag i_${username}_master_test ${registry}:${BUILD_NUMBER}"
                withDockerRegistry([credentialsId:'DockerCredential',url:""]){
                    bat "docker push ${registry}:${BUILD_NUMBER}"
                }
            }
        }
        
        stage('Docker Deployment'){
            steps{
                echo "Deploying docker on local"
                bat "docker run --name c-${username}-master -d -p 7100:9902 ${registry}:${BUILD_NUMBER}"
            }
        }
    }
}
