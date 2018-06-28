package org.apache.maven.plugins.javadoc.resolver;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.File;
import java.util.List;

import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectBuildingRequest;
import org.apache.maven.shared.artifact.filter.resolve.AndFilter;

/**
 * 
 */
public class SourceResolverConfig
{
    private ProjectBuildingRequest buildingRequest;

    private final MavenProject project;

    private AndFilter filter;

    private List<MavenProject> reactorProjects;

    private final File outputBasedir;

    private boolean compileSourceIncluded;

    private boolean testSourceIncluded;

    private final List<String> dependencySourceFilesExcludes;

    /**
     * @param project {@link MavenProject}
     * @param buoildingRequest {@link ProjectBuildingRequest}
     * @param outputBasedir The output base directory.
     */
    public SourceResolverConfig( final MavenProject project, final ProjectBuildingRequest buildingRequest,
                                 final File outputBasedir, final List<String> dependencySourceFilesExcludes )
    {
        this.project = project;
        this.buildingRequest = buildingRequest;
        this.outputBasedir = outputBasedir;
        this.dependencySourceFilesExcludes = dependencySourceFilesExcludes;
    }

    /**
     * @param filter {@link ArtifactFilter}
     * @return {@link SourceResolverConfig}
     */
    public SourceResolverConfig withFilter( final AndFilter filter )
    {
        this.filter = filter;
        return this;
    }

    /**
     * @param reactorProjects The list of reactor projects.
     * @return {@link SourceResolverConfig}
     */
    public SourceResolverConfig withReactorProjects( final List<MavenProject> reactorProjects )
    {
        this.reactorProjects = reactorProjects;
        return this;
    }

    /**
     * @return {@link SourceResolverConfig}
     */
    public SourceResolverConfig withCompileSources()
    {
        compileSourceIncluded = true;
        return this;
    }

    /**
     * @return {@link SourceResolverConfig}
     */
    public SourceResolverConfig withoutCompileSources()
    {
        compileSourceIncluded = false;
        return this;
    }

    /**
     * @return {@link SourceResolverConfig}
     */
    public SourceResolverConfig withTestSources()
    {
        testSourceIncluded = true;
        return this;
    }

    /**
     * @return {@link SourceResolverConfig}
     */
    public SourceResolverConfig withoutTestSources()
    {
        testSourceIncluded = false;
        return this;
    }

    /**
     * @return {@link MavenProject}
     */
    public MavenProject project()
    {
        return project;
    }

    /**
     * @return {@link ProjectBuildingRequest}
     */
    public ProjectBuildingRequest getBuildingRequest()
    {
        return buildingRequest;
    }

    /**
     * @return {@link TransformableFilter}
     */
    public AndFilter filter()
    {
        return filter;
    }

    /**
     * @return list of {@link MavenProject}
     */
    public List<MavenProject> reactorProjects()
    {
        return reactorProjects;
    }

    /**
     * @return {@link #outputBasedir}
     */
    public File outputBasedir()
    {
        return outputBasedir;
    }

    /**
     * @return {@link #compileSourceIncluded}
     */
    public boolean includeCompileSources()
    {
        return compileSourceIncluded;
    }

    /**
     * @return {@link #testSourceIncluded}
     */
    public boolean includeTestSources()
    {
        return testSourceIncluded;
    }

    /**
     * @return {@link #dependencySourceFilesExcludes}
     */
    public List<String> getDependencySourceFilesExcludes()
    {
        return dependencySourceFilesExcludes;
    }
}
