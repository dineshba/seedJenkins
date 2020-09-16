node {
    // define the secrets and the env variables
    // engine version can be defined on secret, job, folder or global.
    // the default is engine version 2 unless otherwise specified globally.
    def secrets = [
        [path: 'secrets/config', engineVersion: 2, secretValues: [
            [envVar: 'username', vaultKey: 'username'],
            [envVar: 'password', vaultKey: 'password']]]
    ]

    // inside this block your credentials will be available as env variables
    withVault([vaultSecrets: secrets]) {
        sh 'echo "withVault block" >> /tmp/jenkins_test'
        sh 'echo "username is $username" >> /tmp/jenkins_test'
        sh 'echo $password >> /tmp/jenkins_test'
        sh 'echo "=====" >> /tmp/jenkins_test'
    }
    
    withCredentials([usernamePassword(credentialsId: 'vault_userpass', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh 'echo "withCredentials block" >> /tmp/jenkins_test'
        sh 'echo $PASSWORD >> /tmp/jenkins_test'
        sh 'echo "username is $USERNAME" >> /tmp/jenkins_test'
        sh 'echo "=====" >> /tmp/jenkins_test'
    }
}
