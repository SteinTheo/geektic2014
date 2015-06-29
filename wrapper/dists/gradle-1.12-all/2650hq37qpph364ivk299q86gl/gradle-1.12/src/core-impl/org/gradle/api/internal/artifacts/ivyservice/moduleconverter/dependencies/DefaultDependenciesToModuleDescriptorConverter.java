/*
 * Copyright 2007-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.internal.artifacts.ivyservice.moduleconverter.dependencies;

import org.apache.ivy.core.module.descriptor.DefaultModuleDescriptor;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ExcludeRule;
import org.gradle.api.artifacts.ModuleDependency;
import org.gradle.api.internal.artifacts.ivyservice.moduleconverter.ExcludeRuleConverter;

import java.util.Collection;

public class DefaultDependenciesToModuleDescriptorConverter implements DependenciesToModuleDescriptorConverter {
    private DependencyDescriptorFactory dependencyDescriptorFactory;
    private ExcludeRuleConverter excludeRuleConverter;

    public DefaultDependenciesToModuleDescriptorConverter(DependencyDescriptorFactory dependencyDescriptorFactory,
                                                          ExcludeRuleConverter excludeRuleConverter) {
        this.dependencyDescriptorFactory = dependencyDescriptorFactory;
        this.excludeRuleConverter = excludeRuleConverter;
    }

    public void addDependencyDescriptors(DefaultModuleDescriptor moduleDescriptor, Collection<? extends Configuration> configurations) {
        assert !configurations.isEmpty();
        addDependencies(moduleDescriptor, configurations);
        addExcludeRules(moduleDescriptor, configurations);
    }

    private void addDependencies(DefaultModuleDescriptor moduleDescriptor, Collection<? extends Configuration> configurations) {
        for (Configuration configuration : configurations) {
            for (ModuleDependency dependency : configuration.getDependencies().withType(ModuleDependency.class)) {
                dependencyDescriptorFactory.addDependencyDescriptor(configuration.getName(), moduleDescriptor, dependency);
            }
        }
    }

    private void addExcludeRules(DefaultModuleDescriptor moduleDescriptor, Collection<? extends Configuration> configurations) {
        for (Configuration configuration : configurations) {
            for (ExcludeRule excludeRule : configuration.getExcludeRules()) {
                org.apache.ivy.core.module.descriptor.ExcludeRule rule = excludeRuleConverter.createExcludeRule(
                        configuration.getName(), excludeRule);
                moduleDescriptor.addExcludeRule(rule);
            }
        }
    }
}
