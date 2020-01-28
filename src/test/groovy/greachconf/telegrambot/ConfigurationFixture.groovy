package greachconf.telegrambot

trait ConfigurationFixture {

    Map<String, Object> getConfiguration() {
        Map<String, Object> m = ['telegram.bots.greachconf.token': 'XXXX']

        if (specName) {
            m['spec.name'] = specName
        }
        m
    }

    String getSpecName() {
        null
    }

}