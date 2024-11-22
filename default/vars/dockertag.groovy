def call(String ImageName, String OldTag, String NewTag) {
    sh "docker tag ${ImageName}:${OldTag} ${ImageName}:${NewTag}"
}