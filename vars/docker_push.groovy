def call(String ProjectName, String Tag){
   withCredentials([usernamePassword('credentialsId':"dockerHubCred", 
                passwordVariable:"dockerHubpass", 
                usernameVariable:"dockerHubUser")]){
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubpass}"
                sh "docker image tag ${ProjectName}:${Tag} ${env.dockerHubUser}/${ProjectName}:${Tag}" 
                sh "docker push ${env.dockerHubUser}/${ProjectName}:${Tag}"

}
