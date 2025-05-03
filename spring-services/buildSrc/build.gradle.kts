plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.openapi.generator.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("ckframeworkMicroservicePlugin") {
            id = libs.plugins.ckframework.microservice.get().pluginId
            implementationClass = "project.plugin.CkframeworkMicroservicePlugin"
        }
        register("ckframeworkOpenapiGeneratorPlugin") {
            id = libs.plugins.ckframework.openapi.generator.get().pluginId
            implementationClass = "project.plugin.CkframeworkOpenapiGeneratorPlugin"
        }
    }
}