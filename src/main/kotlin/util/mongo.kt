package util
import com.mongodb.kotlin.client.coroutine.MongoClient


val connectionString = "mongodb://localhost:27017"
val mongoClient = MongoClient.create(connectionString = connectionString)
val mongoDatabase = mongoClient.getDatabase("sample_restaurants")
