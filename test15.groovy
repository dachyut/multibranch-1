#!groovy
import java.lang.String

class MyClass {
    Script script;       
    
    def exec() {
        script.println "Inside test15 exec method"
        
        withCredentials([string(credentialsId: 'jira_passws', variable: 'AZURE_SERVICE_PRINCIPAL_KEY')]) {
            script.println "Hello !!!!!!!!!!!!!!!!!"
        }
    }
}

return new MyClass(script:this)