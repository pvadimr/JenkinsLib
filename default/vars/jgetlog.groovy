import java.text.SimpleDateFormat

def call(String filename) {
    //def logContent_eng = Jenkins.getInstance()
    //            .getItemByFullName(env.JOB_NAME)
    //            .getBuildByNumber(
    //                Integer.parseInt(env.BUILD_NUMBER))
    //            .logFile.text
            // copy the log in the job's own workspace
    //        writeFile file: "${filename}", text: logContent_eng
	def baos = new ByteArrayOutputStream()
	currentBuild.rawBuild.getLogText().writeLogTo(0, baos)
	def logContent_eng = baos.toString()
	//println(baos.toString())
	writeFile file: "${filename}", text: logContent_eng
}

