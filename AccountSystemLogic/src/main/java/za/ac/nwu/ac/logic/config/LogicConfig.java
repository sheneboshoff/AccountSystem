package za.ac.nwu.ac.logic.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Configuration;
import za.ac.nwu.ac.repo.config.TranslatorConfig;

@Import({TranslatorConfig.class})
@Configuration
public class LogicConfig {
}
