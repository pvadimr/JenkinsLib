def call(String SOURCE, String DESTINATION, String OPTIONS) {
    sh "rsync ${OPTIONS} ${SOURCE} ${DESTINATION}"
}