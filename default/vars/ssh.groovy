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

void SCPTo(String SRC, String DST_HOST, String DST_USER,String DST_PATH)
{
    sh "scp -o \"StrictHostKeyChecking no\" ${SRC} ${DST_USER}@${DST_HOST}:${DST_PATH}"
}

void SCPFrom(String SRC_HOST, String SRC_USER, String SRC_PATH, String DST)
{
    sh "scp -o \"StrictHostKeyChecking no\" ${SRC_USER}@${SRC_HOST}:${SRC_PATH} ${DST}"
}

void SCPBoth(String SRC_HOST, String SRC_USER, String SRC_PATH, String DST_HOST, String DST_USER,String DST_PATH)
{
    sh "scp -o \"StrictHostKeyChecking no\" ${SRC_USER}@${SRC_HOST}:${SRC_PATH} ${DST_USER}@${DST_HOST}:${DST_PATH}"
}