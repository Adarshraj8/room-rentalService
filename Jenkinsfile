pipeline {
    agent any

    environment {
        // Define Docker image name and tag
        IMAGE_NAME = 'adarsh87/java:v2'
        EC2_HOST = '3.110.154.120'  // EC2 instance public IP or hostname
        EC2_USER = 'ubuntu'       // EC2 username (usually ubuntu for Ubuntu-based EC2)
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

        // Stage for Deploy to EC2 via SSH
        stage('Deploy to EC2') {
            steps {
                script {
                    // Use Jenkins credentials for secure SSH access
                    sshagent(['ec2-ssh-key']) { // Replace 'ec2-ssh-key' with your Jenkins SSH credential ID
                        sh """
                            ssh ${EC2_USER}@${EC2_HOST} << EOF
                                echo 'Pulling the latest Docker image from Docker Hub...'
                                docker pull ${IMAGE_NAME}

                                echo 'Stopping any running containers...'
                                docker stop mycontainer || true
                                docker rm mycontainer || true

                                echo 'Running the new container...'
                                docker run -d -p 8070:1000 --name mycontainer ${IMAGE_NAME}
                            EOF
                        """
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
