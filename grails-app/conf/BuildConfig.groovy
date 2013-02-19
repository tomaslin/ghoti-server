grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.work.dir = "target"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
        runtime 'postgresql:postgresql:8.4-702.jdbc3'
    }

    plugins {
        compile ":spring-security-core:1.2.7.3"
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.8.3"
        build ":tomcat:$grailsVersion"
        runtime ":database-migration:1.2.2"
        compile ':cache:1.0.1'
        compile ":console:1.2"
        compile ":recaptcha:0.5.3"

        test(":spock:0.7") {
            exclude "spock-grails-support"
        }
    }
}
