plugins {
    `ckframework-microservice`
    `ckframework-openapi-generator`
}

dependencies {
    implementation(libs.spring.boot.starter.amqp)
}