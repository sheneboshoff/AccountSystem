package za.ac.nwu.ac.repo.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Configuration;

@Import({RepositoryConfig.class})
@Configuration
public class TranslatorConfig {
}
