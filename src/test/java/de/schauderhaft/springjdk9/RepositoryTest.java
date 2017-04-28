/*
 * Copyright 2017 the original author or authors.
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
package de.schauderhaft.springjdk9;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Jens Schauder
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
@ContextConfiguration(classes = TestConfiguration.class)
public class RepositoryTest {

	@Autowired
	PlushAnimalRepository repository;

	@Test
	public void storeAndRetrieve(){

		PlushAnimal animal = new PlushAnimal();
		animal.id = 23L;
		animal.name = "Brumm Ted";
		repository.save(animal);

		Optional<PlushAnimal> reloaded = repository.findOne(23L);

		assertThat(reloaded).contains(animal);
	}

}
