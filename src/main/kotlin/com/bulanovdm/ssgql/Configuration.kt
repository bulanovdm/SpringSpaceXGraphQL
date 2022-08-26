package com.bulanovdm.ssgql

import com.apollographql.apollo3.ApolloClient
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@ConstructorBinding
@ConfigurationProperties("app")
data class ApplicationConfiguration(val request_source: String)

@Configuration
class ClientConfiguration(val configuration: ApplicationConfiguration) {

    @Bean
    fun apolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl(configuration.request_source)
            .build()
    }

    /*@Bean
    fun schema(): GraphQlSource {
        val fileSystemResource = FileSystemResource(Path.of("src/main/resources/graphql/schema.graphqls"))
        return GraphQlSource.schemaResourceBuilder()
            .schemaResources(fileSystemResource)
            .configureRuntimeWiring(runtimeWiringConfigurer())
            .defaultTypeResolver(classNameTypeResolver())
            .build()
    }

    @Bean
    fun runtimeWiringConfigurer(): RuntimeWiringConfigurer {
        val timestamptz = GraphQLScalarType.newScalar(ExtendedScalars.Time).name("timestamptz").build()
        val objectID = GraphQLScalarType.newScalar(ExtendedScalars.Object).name("ObjectID").build()
        val uuid = GraphQLScalarType.newScalar(ExtendedScalars.UUID).name("uuid").build()

        return RuntimeWiringConfigurer { wiringBuilder: RuntimeWiring.Builder ->
            wiringBuilder
                .scalar(ExtendedScalars.Date)
                .scalar(timestamptz)
                .scalar(objectID)
                .scalar(uuid)
        } */
}