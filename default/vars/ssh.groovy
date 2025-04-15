void RunCommand(String HOST, String USER, String COMMAND) {
    sh "ssh -o \"StrictHostKeyChecking no\" ${USER}@${HOST} \"${COMMAND}\""
}

void GetKey(String credid) {
    withCredentials([sshUserPrivateKey(credentialsId: credid, keyFileVariable: 'keyfile')]) {
        sh "mkdir -p ~/.ssh"
        sh "rm -rf ~/.ssh/id_rsa"
        sh "cat $keyfile > ~/.ssh/id_rsa"
        sh "chmod 600 ~/.ssh/id_rsa"
    }
}

void GeneratePublicKey() {
    sh "ssh-keygen -y -f ~/.ssh/id_rsa > ~/.ssh/id_rsa.pub"
}