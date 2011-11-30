 Download jmeter and expand it in /opt/jmeter
 Install ant : sudo apt-get install ant
 Copy ant-jmeter.jar from git repo to /usr/share/ant/lib
 Update conf.txt
 Update generate.groovy with THREAD config
 Run "groovy generate.groovy"
 ./driver.sh (You might have to chmod +x driver.sh to make it executable, duh!)
Find the test results in the "target" folder with the TEST_NAMEs that you specified
