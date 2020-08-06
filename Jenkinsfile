pipeline {
    agent any

    stages {
        stage('Trigger seed') {
            build job: 'seed'
        }
    }
}