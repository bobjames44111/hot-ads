package com.osf.system

import grails.converters.deep.JSON

class Setting {
    
    public Setting(String key, Object value) {
        this()
        this.key = key
        this.clazz = value.class.name
        this.value = value
        this.save(flush: true, failOnError: true)
    }

    String key
    String clazz
    String value
    
    Date dateCreated
    Date lastUpdated
    
    Setting set(Setting setting, Object value) {
        setting.clazz = value.class.name
        setting.value = typeIt(this)
        setting.save(flush: true, failOnError: true)
        return setting
    }
   
    static constraints = {
        key unique: true, nullable: false
        clazz nullable: false
        value nullable: false
    }
    
    JSON toJSON() {
        reurn this as JSON
    }
    
    String toString() {
        return this.toJson().toString(true)
    }
}
