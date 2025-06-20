def call(String ProjectName, String Tag){
   withCredentials([usernamePassword('credentialsId':"dockerHubCred", 
                passwordVariable:"dockerHubpass", 
                usernameVariable:"dockerHubUser")]){
                sh "docker login -u ${dockerHubUser} -p ${dockerHubpass}"
                sh "docker image tag ${ProjectName}:${Tag} ${dockerHubUser}/${ProjectName}:${Tag}" 
                sh "docker push ${dockerHubUser}/${ProjectName}:${Tag}"

}
