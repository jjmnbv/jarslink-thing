package com.yyb.link.config;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;

import java.io.File;
import java.util.List;

/**
 * @author yyb
 * @since 2018-04-13
 * 这里实现定时加载刷新的 module
 */
public class ModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {

    /**
     * 查找和更新 Module
     */
    @Override
    public List<ModuleConfig> queryModuleConfigs() {
        ModuleConfig moduleConfig = buildModuleConfig();
        return ImmutableList.of(moduleConfig);
    }


    /**
     * 加载module的配置
     */
    private static ModuleConfig buildModuleConfig() {
        try {
            // TODO 这里要换成相应的路径
            File dir = new File("/home/yyb/work/jarslink-thing/link-module/build/libs/");

            File[] files = dir.listFiles();
            if (files != null && files.length > 1) {
                File moduleFile = files[0];
                String name = moduleFile.getName();
                ModuleConfig moduleConfig = new ModuleConfig();
                moduleConfig.setName("link-module");
                moduleConfig.setEnabled(true);
                moduleConfig.setVersion(name.replace("link-module-", "").replace(".jar", ""));
                moduleConfig.setModuleUrl(ImmutableList.of(moduleFile.toURI().toURL()));
                return moduleConfig;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

