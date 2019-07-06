/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.start.site.extension;

import io.spring.initializr.generator.test.project.ProjectStructure;
import io.spring.initializr.web.project.ProjectRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link SpringCloudContractProjectContributor}.
 *
 * @author Eddú Meléndez
 */
class SpringCloudContractProjectContributorTests extends AbstractExtensionTests {

	@Test
	void contractsDirectoryIsCreatedWithSpringCloudContractVerifier() {
		ProjectRequest request = createProjectRequest("web", "cloud-contract-verifier");
		ProjectStructure structure = generateProject(request);
		assertThat(structure.getProjectDirectory().resolve("src/test/resources/contracts")).exists().isDirectory();
	}

	@Test
	void contractsDirectoryIsNotCreatedIfSpringCloudContractVerifierIsNotRequested() {
		ProjectRequest request = createProjectRequest("web");
		ProjectStructure structure = generateProject(request);
		assertThat(structure.getProjectDirectory().resolve("src/test/resources/contracts")).doesNotExist();
	}

}
