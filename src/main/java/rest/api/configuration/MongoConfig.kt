package rest.api.configuration

import com.mongodb.MongoClient
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.mapping.MongoMappingContext


@Configuration
open class MongoConfig : AbstractMongoConfiguration() {

    override fun getDatabaseName() = "test"

    override fun mongo() = MongoClient("127.0.0.1", 27017)

    override fun mongoTemplate(): MongoTemplate {
        val converter = MappingMongoConverter(mongoDbFactory(), MongoMappingContext())
        converter.typeMapper = DefaultMongoTypeMapper(null)
        return MongoTemplate(mongoDbFactory(), converter)
    }
}