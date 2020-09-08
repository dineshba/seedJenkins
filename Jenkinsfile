node {
    // define the secrets and the env variables
    // engine version can be defined on secret, job, folder or global.
    // the default is engine version 2 unless otherwise specified globally.
    def secrets = [
        [path: 'secrets/config', engineVersion: 2, secretValues: [
            [envVar: 'testing', vaultKey: 'username'],
            [envVar: 'password', vaultKey: 'password']]]
    ]

    // optional configuration, if you do not provide this the next higher configuration
    // (e.g. folder or global) will be used
    def configuration = [vaultUrl: 'http://192.168.43.253:8200',
                         vaultCredentialId: 'vault-token',
                         engineVersion: 2]
    // inside this block your credentials will be available as env variables
    withVault([configuration: configuration, vaultSecrets: secrets]) {
        sh 'echo $testing >> /tmp/jenkins_test'
        sh 'echo $password >> /tmp/jenkins_test'
    }
}
