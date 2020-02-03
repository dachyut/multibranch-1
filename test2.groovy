#!groovy
import java.lang.String

//def out = new Binding()

class Demo{
	String branchOrCommit='Default'	
	String buildType='FAST'

    Script script;    
    
	def execprint() {    
        script.echo ("Inside class exec")
		final String buildSubJob = 'job1'
        // Start another job
        def job = Hudson.instance.getJob(buildSubJob)
        def anotherBuild		
        def runs = job.getBuilds()		
        def currentBuild = runs[0]
        try {
                def params = [
                    new StringParameterValue('name', 'my-name'),
                    new BooleanParameterValue('build', false)
                ]
                def future = job.scheduleBuild2(0, new Cause.UpstreamCause(currentBuild), new ParametersAction(params))
                //println "Waiting for the completion of " + HyperlinkNote.encodeTo('/' + job.url, job.fullDisplayName)
                buildResult = future.get()
        } //catch (CancellationException x) {
        catch (Exception e) {
            //throw new AbortException("${job.fullDisplayName} aborted.")
            throw(e)
        }        
        script.echo("Job status: ${result}")
    }
}

println("Outside class Demo")
return new Demo(script:this)