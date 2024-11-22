void DockerBuild(String ImageName, String ImageTag) {
    sh "docker build -t ${ImageName}:${ImageTag} ."
}

void DockerLogin(String UsedCredentialsID) {
    withCredentials([usernamePassword(credentialsId: UsedCredentialsID, passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]){
        sh "docker login -u \"${DOCKER_USERNAME}\" -p \"${DOCKER_PASSWORD}\""
    }
}

void DockerPush(String ImageName, String ImageTag) {
    sh "docker push ${ImageName}:${ImageTag}"
}

void DockerTag(String ImageName, String OldTag, String NewTag) {
    sh "docker tag ${ImageName}:${OldTag} ${ImageName}:${NewTag}"
}

void DockerCleanUp(){
    sh "docker system prune -a -f"
}