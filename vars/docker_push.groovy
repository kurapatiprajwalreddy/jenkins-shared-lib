// def call(String ProjectName, String Tag){
//    withCredentials([usernamePassword('credentialsId':"dockerHubCred", passwordVariable:"dockerHubpass", usernameVariable:"dockerHubUser")]){
//       sh "docker login -u ${dockerHubUser} -p ${dockerHubpass}"
//       sh "docker image tag ${ProjectName}:${Tag} ${dockerHubUser}/${ProjectName}:${Tag}" 
//       sh "docker push ${dockerHubUser}/${ProjectName}:${Tag}"

// }
/**
 * This function is responsible for logging into DockerHub and pushing a Docker image.
 * 
 * @param ProjectName: The name of the Docker image/project.
 * @param Tag: The tag/version of the Docker image.
 */
def call(String ProjectName, String Tag) {
    // Authenticate with DockerHub using Jenkins credentials
    withCredentials([usernamePassword(credentialsId: "dockerHubCred", 
                                      passwordVariable: "dockerHubpass", 
                                      usernameVariable: "dockerHubUser")]) {
        // Login to DockerHub
        sh "docker login -u ${dockerHubUser} -p ${dockerHubpass}"
        
        // Tag the Docker image
        sh "docker image tag ${ProjectName}:${Tag} ${dockerHubUser}/${ProjectName}:${Tag}"
        
        // Push the Docker image to DockerHub
        sh "docker push ${dockerHubUser}/${ProjectName}:${Tag}"
    } // Closes the withCredentials block
} // Closes the call function
