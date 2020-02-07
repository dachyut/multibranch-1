#!groovy
import java.lang.String
import io.jenkins.plugins.analysis.core.*
import io.jenkins.plugins.analysis.core.steps.*
import io.jenkins.plugins.analysis.core.model.*

class MyClass extends absClass {
    Script script;       
    
    def exec() {
        script.println "Inside test6 exec method"
        final String buildLog = 'build.log, **/build.log'
    
            
        //recordIssues(tools: [msBuild(pattern: buildLog)])

        //def t = steps.RecordIssuesStep.setTools('msbuild')
        //script.println "${t}"
        script.recordIssues (tools : "msbuild")
        //script.recordIssues(enabledForFailure: true, aggregatingResults: true,
        //    tools: t)
        //.msBuild(pattern: buildLog)
        //script.recordIssues(tools: msbld)
    }
}

return new MyClass(script:this)