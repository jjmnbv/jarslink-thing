package com.yyb.link.config;

import com.alipay.jarslink.api.impl.ModuleLoaderImpl;
import com.alipay.jarslink.api.impl.ModuleManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yyb
 * @since 2018-04-13
 * 这里将 ModuleLoaderImpl 、 ModuleManagerImpl 、 ModuleRefreshSchedulerImpl 加载到 bean 里
 */
@Configuration
public class ModuleConfiguration {


    @Bean
    public ModuleLoaderImpl moduleLoader() {
        return new ModuleLoaderImpl();
    }

    @Bean
    public ModuleManagerImpl moduleManager() {
        return new ModuleManagerImpl();
    }

    @Bean
    public ModuleRefreshSchedulerImpl moduleRefreshScheduler() {
        ModuleRefreshSchedulerImpl moduleRefreshScheduler = new ModuleRefreshSchedulerImpl();
        moduleRefreshScheduler.setModuleLoader(moduleLoader());
        moduleRefreshScheduler.setModuleManager(moduleManager());
        return moduleRefreshScheduler;
    }
}
