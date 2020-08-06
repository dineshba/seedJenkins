FROM jenkinsci/blueocean:latest
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
COPY config.xml /usr/share/jenkins/seed-job-config.xml
COPY create-seed-job.groovy /usr/share/jenkins/ref/init.groovy.d/create-seed-job.groovy
