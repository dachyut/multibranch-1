    def exec() {
        ////echo "Inside exec method"
        def name = "PipelineJob2"
        def archiveName = 'build.properties'
        try {
            println("CopyArtifacts.........")
            step($class: 'hudson.plugins.copyartifact.CopyArtifact', projectName: name, selector: lastSuccessful(), filter: 'build.properties',fingerprintArtifacts: true, target: 'd:\\artifacts')
            println("Archive artifacts")
            step(archiveArtifacts(artifacts: archiveName, fingerprint: true))
        } catch (none) {
            ////echo 'No artifact to copy from ' + name 
            //writeFile file: archiveName, text: '3'
        }
        println("Current dirctory......")
        def currentDir = new File(".").getAbsolutePath()
        println currentDir
        // def rootFiles = new File("test").listRoots() 
        // rootFiles.each { file -> script.echo(file.absolutePath) }

        // script.echo("File contents.......")
        // File file = new File(archiveName)
        // def lines = file.text
        // script.echo("File : ${archiveName}")        
    }


return this