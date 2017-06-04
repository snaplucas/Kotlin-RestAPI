package rest.api.port.adapter.configuration

import com.mongodb.MongoClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.mapping.MongoMappingContext


@Configuration
open class MongoConfig : AbstractMongoConfiguration() {

    @Value("\${mongodb.database}")
    lateinit var database: String

    @Value("\${mongodb.host}")
    lateinit var host: String

    @Value("\${mongodb.port}")
    lateinit var port: String

    override fun getDatabaseName() = database

    override fun mongo() = MongoClient(host, port.toInt())

    override fun mongoTemplate(): MongoTemplate {
        val converter = MappingMongoConverter(mongoDbFactory(), MongoMappingContext())
        converter.typeMapper = DefaultMongoTypeMapper(null)
        return MongoTemplate(mongoDbFactory(), converter)
    }
}