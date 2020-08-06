How it works
============
There are two folders 
    - jenkinsSeedJobs - which contains the groovy files to create the seed job and definitions to create the folder and git repo where we scan the jenkinsfiles to create the jobs. These files can be clubbed 
    with jenkins infra creation in order to create the seed job.
            - aaa_folders.groovy - to create a new folder in jenkins
            - build_pipelines.groovy - to define the remote git repo from where we scan for the projects
            - create-seed-job.groovy - Config to create the initial seed job
            - config.xml - helper config for the creation of initial seed job
            - plugins.groovy - for creation of plugins by reading the plugin.txt
    - src-devops-jobsconfig - Where Jobsfile exists, where the developers can add a entry when ever a new job is created.
                                      
Steps to deploy seed jobs
=========================

1) Go to jenkinsSeedJobs folder
2) Open the Dockerfile and check and update for any changes
3) Build a docker image from the folder 
    # cd jenkinsSeedJobs
    # cat Dockerfile 
    # docker build . -t local/jenkins
4) Create Jenkins using the image we created in the above step
    # docker run -d --name jenkins -p 8080:8080 local/jenkins
5) Open jenkins once it is up
6) Jenkins would come up with a Seed job created already
7) Run the Seed job and it would create the below
    - a new folder with the configuration specified in aaa_folders.groovy
    - jobs inside the new folder - the jobs are defined in the repo src-devops-jobsconfig
8) when you add a new job, update the jobsfile in src-devops-jobsconfig and run the seed job in jenkins which would create the new job

