def call() {
    def gitHash = sh returnStdout: true, script: 'git rev-parse HEAD |tr -d \'\\n\''
    return gitHash;
}