package greachconf.telegrambot

trait ConfigurationFixture {

    Map<String, Object> getConfiguration() {
        Map<String, Object> m = new HashMap<>()
        if (specName) {
            m['spec.name'] = specName
        }
        m
    }

    String getSpecName() {
        null
    }

}