def call() {
    def gitHashShort = sh returnStdout: true, script: 'git rev-parse --short HEAD |tr -d \'\\n\''
    return gitHashShort;
}