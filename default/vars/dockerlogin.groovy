def call(String UsedCredentialsID) {
    withCredentials([usernamePassword(credentialsId: UsedCredentialsID, passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]){
        sh "docker login -u \"${DOCKER_USERNAME}\" -p \"${DOCKER_PASSWORD}\""
    }
}