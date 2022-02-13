package com.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties",
        "file:${user.dir}/src/test/resources/dev-config.properties",
        "file:${user.dir}/src/test/resources/staging-config.properties"
})
public interface FrameworkConfig extends Config {

    String browser();

    @DefaultValue("staging")
    String environment();

    @Key("${environment}.username")
    String username();

    @Key("${environment}.url")
    String url();

}
