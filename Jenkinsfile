pipeline {
    agent any

    environment {
        // Define Docker image name and tag
        IMAGE_NAME = 'adarsh87/java:v2'
    }

    tools {
        jdk 'jdk17'   // Jenkins JDK Tool Configuration
        maven 'maven3' // Maven version set in Jenkins
    }

    stages {
        // Stage for Git Checkout
        stage('Git Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Adarshraj8/room-rentalService.git'
            }
        }
        
        // Stage for Maven Build
        stage('Build Project with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'  // Build the project and create JAR
            }
        }

        // Stage for Docker Build
        stage('Docker Build') {
            steps {
                script {
                    // Build Docker Image
                    sh 'docker build -t ${IMAGE_NAME} .'
                }
            }
        }

        // Stage for Docker Push
        stage('Docker Push') {
            steps {
                script {
                    // Push the image to Docker Hub using credentials
                    withDockerRegistry(credentialsId: 'dockerhub', url: 'https://index.docker.io/v1/') {
                        sh 'docker push ${IMAGE_NAME}'
                    }
                }
            }
        }
        
        // Optional: Deploy to Kubernetes (If needed)
        stage('Deploy to Kubernetes') {
            steps {
                script {
                    withKubeConfig(credentialsId: 'k8s', serverUrl: 'https://your-k8s-cluster-url') {
                        // Assuming you have Kubernetes deployment YAML files to apply
                        sh 'kubectl apply -f deployment.yaml'
                        sh 'kubectl apply -f service.yaml'
                    }
                }
            }
        }
    }

    post {
        // Handle cleanup and notifications after build
        always {
            echo 'Build and deployment process completed!'
        }
    }
}
