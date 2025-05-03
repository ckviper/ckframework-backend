plugins {
    `ckframework-microservice`
    `ckframework-openapi-generator`
}

dependencies {
//    implementation(project(":common"))
    implementation(libs.spring.boot.starter.web)
    implementation(libs.database.postgresql)
    implementation(libs.database.h2)
    implementation(libs.bundles.jwt)
    implementation(libs.bundles.resourceSecurity)
}

group = "com.viper.ckframework.keymanager"
version = "0.0.1-SNAPSHOT"