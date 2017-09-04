package rest.api.port.adapter.configuration

import com.mongodb.MongoClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.mapping.MongoMappingContext


@Configuration
@ConfigurationProperties("mongodb")
open class MongoConfig : AbstractMongoConfiguration() {

    @Value("\${mongodb.database}")
    lateinit var database: String

    override fun getDatabaseName() = database

    override fun mongo() = MongoClient()

    override fun mongoTemplate(): MongoTemplate {
        val converter = MappingMongoConverter(mongoDbFactory(), MongoMappingContext())
        converter.typeMapper = DefaultMongoTypeMapper(null)
        return MongoTemplate(mongoDbFactory(), converter)
    }
}