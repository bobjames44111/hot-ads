package com.osf.system

import grails.transaction.Transactional

@Transactional
class SettingService {

    Setting put(String key, Object value) {
        Setting setting = Setting.findByKey(key)
        if(!setting) {
            setting = new Setting(key, value)
        } else {
            Setting.set(setting, value)
        }
        return setting
    }
    
    Setting get(String key) {
        return setting.findByKey(key)
    }
}
