class BootStrap {

    def settingService
    
    def init = { servletContext ->
        settingService.put("test", new Date())
    }

    def destroy = {
    }
}
