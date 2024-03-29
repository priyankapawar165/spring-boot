package com.employee;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters({
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.employee.step"),
        @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "not @Disabled"),
        @ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true"),
        @ConfigurationParameter(key = JUNIT_PLATFORM_NAMING_STRATEGY_PROPERTY_NAME, value = "long"),
        @ConfigurationParameter(
                key = "cucumber.plugin",
                value = "pretty, summary, timeline:target/reports/timeline, html:target/reports/cucumber.html"
        )
})
public class CucumberRunner {
}
