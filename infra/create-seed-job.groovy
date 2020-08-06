// This script is run as part of initializing Jenkins.
// It creates a seed job and copies the required DSL script to its workspace
import jenkins.model.*

println "Creating seed job"
new File("/usr/share/jenkins/seed-job-config.xml").withInputStream { stream ->
  Jenkins.instance.createProjectFromXML("seed", stream)
}

def commands = [
    "mkdir -p /var/jenkins_home/workspace/seed",
    "cp -v /usr/share/jenkins/aaa_folders.groovy /var/jenkins_home/workspace/seed/aaa_folders.groovy",
    "cp -v /usr/share/jenkins/build_pipelines.groovy /var/jenkins_home/workspace/seed/build_pipelines.groovy",
    "cp -v /usr/share/jenkins/plugins.groovy /var/jenkins_home/workspace/seed/plugins.groovy"
   ]
commands.each {
  println "Executing command ${it}"
  def process = it.execute()
  process.waitFor()

  def output = process.in.text
  println output
}