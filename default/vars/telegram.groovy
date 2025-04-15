void SendMessage(String CHAT_ID, String API_TOKEN, String MESSAGE_TEXT) {
    sh "curl -s -o /dev/null -X POST -H \"Content-Type: application/json\" -d \"{\\\"chat_id\\\": \\\"${CHAT_ID}\\\", \\\"text\\\": \\\"${MESSAGE_TEXT}\\\", \\\"disable_notification\\\": false}\" https://api.telegram.org/bot${API_TOKEN}/sendMessage"
}