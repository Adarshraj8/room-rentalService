pipeline {
    agent any

    environment {
        // Define Docker image name and tag
        IMAGE_NAME = 'adarsh87/java:v2'
        EC2_HOST = '13.233.21.83'  // EC2 instance public IP or hostname
        EC2_USER = 'ubuntu'         // EC2 username (usually ubuntu for Ubuntu-based EC2)
        SSH_KEY_PATH = '/home/ubuntu/youtube-key.pem'  // Replace this with the actual path to your SSH private key
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
                    sh "docker build -t ${IMAGE_NAME} ."
                }
            }
        }

        // Stage for Docker Push (Optional)
        stage('Docker Push') {
            steps {
                script {
                    // Push the image to Docker Hub using credentials
                    withDockerRegistry(credentialsId: 'dockerhub', url: 'https://index.docker.io/v1/') {
                        sh "docker push ${IMAGE_NAME}"
                    }
                }
            }
        }

        // Stage for Deploy to EC2 via SSH
        stage('Deploy to EC2') {
            steps {
                script {
                    // Ensure SSH key permissions are set correctly
                    sh "chmod 400 ${SSH_KEY_PATH}"

                    // SSH into EC2 instance and deploy Docker container
                    sh """
                        ssh -i ${SSH_KEY_PATH} ${EC2_USER}@${EC2_HOST} << EOF
                            echo 'Pulling the latest Docker image from Docker Hub...'
                            docker pull ${IMAGE_NAME}

                            echo 'Stopping and removing any old containers...'
                            docker stop mycontainer || true
                            docker rm mycontainer || true

                            echo 'Removing old Docker images...'
                            docker rmi ${IMAGE_NAME} || true

                            echo 'Running the new container...'
                            docker run -d -p 8070:1000 --name mycontainer ${IMAGE_NAME}

                            echo 'Checking Docker container status...'
                            docker ps -a
                        EOF
                    """
                }
            }
        }
    }

    post {
        always {
            echo 'Build and deployment process completed!'
        }

        success {
            echo 'Deployment to EC2 was successful!'
        }

        failure {
            echo 'Something went wrong with the build or deployment.'
        }
    }
}
