node {
    // define the secrets and the env variables
    // engine version can be defined on secret, job, folder or global.
    // the default is engine version 2 unless otherwise specified globally.
    def secrets = [
        [path: 'secrets/config', engineVersion: 2, secretValues: [
            [envVar: 'testing', vaultKey: 'username'],
            [envVar: 'password', vaultKey: 'password']]]
    ]

    // inside this block your credentials will be available as env variables
    withVault([vaultSecrets: secrets]) {
        sh 'echo $testing >> /tmp/jenkins_test'
        sh 'echo $password >> /tmp/jenkins_test'
    }
}
