package com.getghoti

class Boilerplate {

	Date dateCreated
	Date lastUpdated
	String name
	String description
	String url
	Boolean approved = false

    static constraints = {
    	name()
		description()
		url(url:true)
	}
	
	static namedQueries = {
       approvedTemplates {
			eq 'approved', true
	   }
	}
}
