plugins {
    `ckframework-microservice`
}

dependencies{
    implementation(libs.spring.cloud.starter.gateway)
    implementation(libs.spring.boot.starter.webflux)
    implementation(libs.bundles.resourceSecurity)
    implementation(libs.bundles.jwt)
}

group = "com.viper.ckframework.gateway"
version = "0.0.1-SNAPSHOT"