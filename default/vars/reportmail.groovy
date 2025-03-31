import java.text.SimpleDateFormat

def call(String reportToEmail, String Body) {
    sh "echo \"${Body}\" >> email_body.hmtl"
	emailext attachLog: true, body: '${FILE,path="email_body.hmtl"}', compressLog: true, mimeType: 'text/html', recipientProviders: [requestor()], subject: '$DEFAULT_SUBJECT', to: '${reportToEmail}'
}