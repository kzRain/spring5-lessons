package kz.cf.spring5.lesson5.test;

import org.junit.experimental.ParallelComputer;
import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;
/**
 * Created by ruslan on 8/6/17.
 */

public class ParallelTests {
	@Test
	void executeTwoInParallel() {
		final Class<?>[] classes = {
				IntegrationOneTest.class, IntegrationTwoTest.class
		};

		JUnitCore.runClasses(new ParallelComputer(true, true), classes);
	}

}
