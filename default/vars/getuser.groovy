import java.text.SimpleDateFormat
@NonCPS
def call() {
	USERNAME = currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId();
	return USERNAME;
}

