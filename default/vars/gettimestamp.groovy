import java.text.SimpleDateFormat
@NonCPS
def call(String format) {
    def dateFormat = new SimpleDateFormat("${format}")
	def date = new Date()
	STRINGDATE = dateFormat.format(date)
	return STRINGDATE;
}

