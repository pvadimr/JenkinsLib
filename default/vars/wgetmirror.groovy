def call(String SOURCE, String DESTINATION) {
	sh "wget --mirror --page-requisites --adjust-extension --no-parent --convert-links --directory-prefix=${DESTINATION} ${SOURCE}"
}