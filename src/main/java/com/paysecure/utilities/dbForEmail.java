package com.paysecure.utilities;


import java.util.Arrays;


import org.bson.Document;
import org.testng.Assert;
import org.testng.Reporter;


import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.paysecure.base.baseClass;

public class dbForEmail {
	static MongoCollection<Document> collection;
	static MongoClient mongoClient;
	public void createConnectionForDB() {
	    try {
	       
	        String uri = baseClass.getProp().getProperty("mongo.uri", 
	                        "mongodb://PGS:PGSReady@172.31.88.8:27127/?authSource=PGS");

	        mongoClient = MongoClients.create(uri);

	        // 🔹 Read DB & collection name from config if possible
	      //  String dbName = baseClass.getProp().getProperty("mongo.db", "PGS");
	        String dbName   =  baseClass.getProp().getProperty("datasource.username");
	        String collectionName =       baseClass.getProp().getProperty("datasource.collection");
	       // String collectionName = baseClass.getProp().getProperty("mongo.collection", "customerTransaction");

	        MongoDatabase database = mongoClient.getDatabase(dbName);
	        collection = database.getCollection(collectionName);

	        Reporter.log("✅ Connected to MongoDB: " + dbName + "." + collectionName, true);

	    } catch (Exception e) {
	        Reporter.log("❌ Failed to connect to MongoDB: " + e.getMessage(), true);
	        e.printStackTrace();
	        throw e; // Rather so tests fail fast
	    }
	
	}
	
	public static int getdaysInYearCount(String emailId) {
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
		        Aggregates.match(
		            Filters.and(
		                Filters.eq("emailId", emailId),
		                Filters.in("year", Arrays.asList("2024", "2025")),
		                Filters.eq("merchantId", "603")
		              //  Filters.eq("parentId", 0)
		            )
		        ),
		        Aggregates.group(null,
		            Accumulators.addToSet("dayInYear", "$dayInYear") 
		        ),
		        Aggregates.project(Projections.fields(
		            Projections.computed("dayCount", new Document("$size", "$dayInYear"))
		        ))
		    ));

		    Document doc = result.first();
		    if (doc != null) {
		        return doc.getInteger("dayCount", 0);
		    } else {
		        return 0; // No records found
		    }
		}
	
	public static int getmonthInYearCount(String emailId) {
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
		        Aggregates.match(
		            Filters.and(
		                Filters.eq("emailId", emailId),
		                Filters.in("year", Arrays.asList("2024", "2025")) ,
		                Filters.eq("merchantId", "603")
		            )
		        ),
		        Aggregates.group(null,
		            Accumulators.addToSet("month", "$month") 
		        ),
		        Aggregates.project(Projections.fields(
		            Projections.computed("monthCount", new Document("$size", "$month"))
		        ))
		    ));

		    Document doc = result.first();
		    if (doc != null) {
		        return doc.getInteger("monthCount", 0);
		    } else {
		        return 0; // No records found
		    }
		}
	
	
	public static int getYearCount(String emailId) {
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
		        Aggregates.match(
		            Filters.and(
		                Filters.eq("emailId", emailId),
		                Filters.in("year", Arrays.asList("2024", "2025")),
		                Filters.eq("merchantId", "603")
		            )
		        ),
		        Aggregates.group(null,
		            Accumulators.addToSet("year", "$year") 
		        ),
		        Aggregates.project(Projections.fields(
		            Projections.computed("yearCount", new Document("$size", "$year"))
		        ))
		    ));

		    Document doc = result.first();
		    if (doc != null) {
		        return doc.getInteger("yearCount", 0);
		    } else {
		        return 0; // No records found
		    }
		}
	
	public static int getWeeklyCount(String emailId) {
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
		        Aggregates.match(
		            Filters.and(
		                Filters.eq("emailId", emailId),
		                Filters.in("year", Arrays.asList("2024", "2025")),
		                Filters.eq("merchantId", "603")
		            )
		        ),
		        Aggregates.group(null,
		            Accumulators.addToSet("weekInYear", "$weekInYear") 
		        ),
		        Aggregates.project(Projections.fields(
		            Projections.computed("weekCount", new Document("$size", "$weekInYear"))
		        ))
		    ));

		    Document doc = result.first();
		    if (doc != null) {
		        return doc.getInteger("weekCount", 0);
		    } else {
		        return 0; // No records found
		    }
		}
	
	
	public static int getMerchantFrequency(String emailId) {
	    AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
	        // Stage 1: Match by emailId, parentId, and year filter
	        Aggregates.match(Filters.and(
	            Filters.eq("emailId", emailId),
	            Filters.in("year", Arrays.asList("2024", "2025")),
	            Filters.eq("merchantId", "603")
	        )),

	        // Stage 2: Group to collect unique merchantIds
	        Aggregates.group(null,
	            Accumulators.addToSet("merchantIds", "$merchantId")  // plural for clarity
	        ),

	        // Stage 3: Project the count of unique merchants
	        Aggregates.project(Projections.fields(
	            Projections.computed("merchantCount",
	                new Document("$size", "$merchantIds"))  // reference to grouped field
	        ))
	    ));

	    Document doc = result.first();
	    if (doc != null) {
	        Object countObj = doc.get("merchantCount");
	        if (countObj instanceof Integer) {
	            return (Integer) countObj;
	        } else if (countObj instanceof Double) {
	            return ((Double) countObj).intValue();
	        } else {
	            return 0;
	        }
	    } else {
	        return 0; // No records found
	    }
	}

	
	public static int getCustomersIPCount(String emailId) {
	    AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
	        // Stage 1: Match by emailId and year (either 2024 or 2025)
	        Aggregates.match(
	            Filters.and(
	                Filters.eq("emailId", emailId),
	                Filters.in("year", Arrays.asList("2024", "2025")),
	                Filters.eq("merchantId", "603")
	            )
	        ),

	        // Stage 2: Group all matched docs together, collect unique IPs into a set
	        Aggregates.group(null,
	            Accumulators.addToSet("requestIpCCode", "$requestIpCCode")
	        ),

	        // Stage 3: Project the size of the set as ipAddressCount
	        Aggregates.project(Projections.fields(
	            Projections.computed("ipAddressCount", new Document("$size", "$requestIpCCode"))
	        ))
	    ));

	    Document doc = result.first();
	    if (doc != null) {
	        return doc.getInteger("ipAddressCount", 0); // number of unique IPs
	    } else {
	        return 0; // No records found
	    }
	}

	
	public static int getCustomersCardFrequency(String emailId) {
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
				Aggregates.match(
						Filters.and(
						Filters.eq("emailId", emailId),
						Filters.in("year", Arrays.asList("2023","2024", "2025")),
						Filters.eq("merchantId", "603")
						)
				),
				
			    // Stage 2: Group all matched docs together, collect unique IPs into a set
		        Aggregates.group(null,
		            Accumulators.addToSet("maskednumber", "$maskednumber")
		        ),
		        
		        // Stage 3: Project the size of the set as ipAddressCount
		        Aggregates.project(Projections.fields(
		            Projections.computed("maskednumber", new Document("$size", "$maskednumber"))
		        ))
		    ));
		   Document doc = result.first();
		    if (doc != null) {
		        return doc.getInteger("maskednumber", 0); // number of unique IPs
		    } else {
		        return 0; // No records found
		    }
	}
	
	public static int getCustomersCountryFrequency(String emailId) {
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
				Aggregates.match(
						Filters.and(
						Filters.eq("emailId", emailId),
						Filters.in("year", Arrays.asList("2023","2024", "2025")),
						Filters.eq("merchantId", "603")
						)
				),
				
			    // Stage 2: Group all matched docs together, collect unique IPs into a set
		        Aggregates.group(null,
		            Accumulators.addToSet("country", "$country")
		        ),
		        
		        // Stage 3: Project the size of the set as ipAddressCount
		        Aggregates.project(Projections.fields(
		            Projections.computed("country", new Document("$size", "$country"))
		        ))
		    ));
		   Document doc = result.first();
		    if (doc != null) {
		        return doc.getInteger("country", 0); // number of unique IPs
		    } else {
		        return 0; // No records found
		    }
	}
	
	public static int getAmtFrequency(String emailId) {
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
				Aggregates.match(
						Filters.and(
						Filters.eq("emailId", emailId),
						Filters.in("year", Arrays.asList("2023","2024", "2025")),
						Filters.eq("merchantId", "603")
						)
				),
				
			    // Stage 2: Group all matched docs together, collect unique IPs into a set
		        Aggregates.group(null,
		            Accumulators.addToSet("amt", "$amt")
		        ),
		        
		        // Stage 3: Project the size of the set as ipAddressCount
		        Aggregates.project(Projections.fields(
		            Projections.computed("amt", new Document("$size", "$amt"))
		        ))
		    ));
		   Document doc = result.first();
		    if (doc != null) {
		        return doc.getInteger("amt", 0); // number of unique IPs
		    } else {
		        return 0; // No records found
		    }
	}
	
//	public static int getTPaidTransactionsFrequency(String emailId) {
//		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
//				Aggregates.match(
//						Filters.and(
//						Filters.eq("emailId", emailId),
//						Filters.eq("lastAction", "PAID"),
//						Filters.eq("merchantId", "603")
//						)
//				),
//				
//			    // Stage 2: Group all matched docs together, collect unique IPs into a set
//		        Aggregates.group(null,
//		            Accumulators.addToSet("paid_amount_in_usd", "$paid_amount_in_usd")
//		        ),
//		        
//		        // Stage 3: Project the size of the set as ipAddressCount
//		        Aggregates.project(Projections.fields(
//		            Projections.computed("paid_amount_in_usd", new Document("$size", "$paid_amount_in_usd"))
//		        ))
//		    ));
//		   Document doc = result.first();
//		    if (doc != null) {
//		        return doc.getInteger("paid_amount_in_usd", 0); // number of unique IPs
//		    } else {
//		        return 0; // No records found
//		    }
//	}
	
	public static int getTotalPaidTransactions(String emailId) {
	    AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
	        Aggregates.match(Filters.and(
	            Filters.eq("emailId", emailId),
	            Filters.eq("lastAction", "PAID"),
	            Filters.eq("merchantId", "603")
	        )),
	        Aggregates.count("totalPaidTransactions")
	    ));

	    Document doc = result.first();
	    if (doc != null) {
	        return doc.getInteger("totalPaidTransactions", 0);
	    } else {
	        return 0;
	    }
	}

	
	public static int getCountOfEmail(String emailId) {
	    AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
	        // Stage 1: Match documents by emailId
	    		  Aggregates.match(Filters.and(
	    		            Filters.eq("emailId", emailId),
	    		            Filters.eq("merchantId", "603")
	    		        )),

	        // Stage 2: Group all matched documents and count them
	        Aggregates.group(null,
	            Accumulators.sum("emailCount", 1)
	        ),

	        // Stage 3: Project only the count
	        Aggregates.project(Projections.fields(
	            Projections.computed("emailCount", "$emailCount")
	        ))
	    ));

	    Document doc = result.first();
	    if (doc != null) {
	        return doc.getInteger("emailCount", 0);
	    } else {
	        return 0;  // No documents found
	    }
	}

//-----------------------------------------------------------------------------------
	public static int getCountOfMerchantEmailIDS(String emailId, String merchantId) {
	    AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
	        // Stage 1: Match by emailId and merchantId
	        Aggregates.match(Filters.and(
	            Filters.eq("emailId", emailId),
	            Filters.eq("merchantId", merchantId)
	        )),

	        // Stage 2: Group matched documents and count them
	        Aggregates.group(null,
	            Accumulators.sum("merchantCount", 1)
	        ),

	        // Stage 3: Project only the count field
	        Aggregates.project(Projections.fields(
	            Projections.computed("merchantCount", "$merchantCount")
	        ))
	    ));

	    Document doc = result.first();
	    if (doc != null) {
	        return doc.getInteger("merchantCount", 0);
	    } else {
	        return 0;  // No documents found
	    }
	}

	
}
