pipeline {
    agent any
    stages {
        stage('Maven build、test') {
            steps {
                sh "mvn --version"
                sh "mvn clean package"
                echo "构建成功"
            }
        }
        stage('docker compose') {
            steps {
                echo "运行成功"
            }
        }
    }
}