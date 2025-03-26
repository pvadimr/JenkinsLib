void RunCommand(String HOST, String USER, String COMMAND) {
    sh "ssh -o \"StrictHostKeyChecking no\" ${USER}@${HOST} \"${COMMAND}\""
}