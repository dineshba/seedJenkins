
def commands = [
  ]
  commands.each {
    println "Executing command ${it}"
    def process = it.execute()
    process.waitFor()

    def output = process.in.text
    println output
  }

def projects = "java-microservice-template"

def generateMultibranchBuildJobs(String folder, String applicationCode, String[] projects ) {
    for (String project : projects) {
        def projectName = project.substring(1+project.lastIndexOf("/"))
        multibranchPipelineJob("${folder}/${projectName}") {
            branchSources {
                git {
                    id("${folder}-${project}") // IMPORTANT: use a constant and unique identifier
                    remote("https://github.com/dineshba/${project}.git")
                }
            }
            factory {
                workflowBranchProjectFactory {
                    scriptPath('Jenkinsfile')
                }
            }
        }
    }
}

generateMultibranchBuildJobs("devops", "devops", projects)
