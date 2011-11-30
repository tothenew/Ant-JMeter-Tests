#!/usr/bin/env groovy
File driverFile = new File("driver.sh");
driverFile.text="";
String driverFileText = ""
String THREADS = 5 
String DURATION = 10 //In seconds
String TEST_NAME = "Project"
String TEST_TITLE = "Project title"
String buildTemplate = new File("build.xml.template").text
String jmxTemplate = new File("project.jmx.template").text
File conf = new File("conf.txt");
conf.eachLine { line ->
	if(!line.startsWith('#')){
		def tokens = line.tokenize(",")
		String HOST = tokens[0].trim()
		String PORT = tokens[1].trim()
		String PATH = tokens[2].trim()
		String DESC = tokens[3].trim()
		File f = new File("build_${DESC}.xml");
		f.text = buildTemplate.replaceAll("##DESC##", DESC);
		
		f = new File("${DESC}.jmx");
		f.text = jmxTemplate.replaceAll("##DESC##", DESC).replaceAll("##THREADS##", THREADS).replaceAll("##PORT##", PORT).replaceAll("##DURATION##", DURATION).replaceAll("##PATH##", PATH).replaceAll("##HOST##", HOST).replaceAll("##TEST_NAME##", TEST_NAME).replaceAll("##TEST_TITLE##", TEST_TITLE);
		driverFileText  = driverFileText +  "ant -f build_${DESC}.xml;"
		println driverFileText
	}
}
driverFile.text = driverFileText
