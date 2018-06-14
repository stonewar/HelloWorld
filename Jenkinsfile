pipeline {
    agent any
    stages {
         stage('Test') {
            steps {
              sh 'mvn test'
            }
         }
         stage('Install') {
            steps {
               sh 'mvn install -DskipTests'
            }
         }
        stage('Push image to ecr') {
            steps {
                script {
                    docker.withRegistry("https://882452424692.dkr.ecr.us-east-1.amazonaws.com/hello-world", "ecs-credentials") {
                    token = sh(script: 'aws ecr get-login --no-include-email', returnStdout: true)
                    echo "${token}"
                    docker.image("882452424692.dkr.ecr.us-east-1.amazonaws.com/hello-world").push()
                    }
                }
            }
        }
        stage('Deploy to ECS') {
            steps {
                script {
                    sh 'ecs-deploy -c HelloWorld-Cluster -n HelloWorldService -i 882452424692.dkr.ecr.us-east-1.amazonaws.com/hello-world:latest -t 600'
                }
            }
        }
    }
}