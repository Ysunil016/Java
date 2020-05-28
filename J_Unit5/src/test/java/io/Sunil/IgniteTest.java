package io.Sunil;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.function.Supplier;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

// Custom Test Instance Behaviour - Single Instance of IgniteTest
@TestInstance(Lifecycle.PER_CLASS)
class IgniteTest {

	Ignite ignite;

	TestInfo testInfo;
	TestReporter testReporter;

	// By Default Engine will Instantiate this Class for Each @Test Cases.
	// Constructor
	public IgniteTest() {
		System.out.println("Constructor");
	}

	// Runs for Once for the Class Before Starting Testing, Even Before Jupiter
	// Engine Instantiate the Class - Static.
	// No Need of Static - When there is PER_CLASS Test TestInstance.
	@BeforeAll
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		System.out.println("Initiated Test");
	}

	// Runs for Each @Test in the Class
	@BeforeEach
	void init_each() {
		System.out.println("Instantiating Ignite");
		this.ignite = new Ignite();
	}

	// Runs for Each @Test in the Class
	@AfterEach
	void destory_each() {
		System.out.println("Ignite Destroy");
	}

	// Runs for Once for the Class when Testing is Done
	@AfterAll
	static void destroy() {
		System.out.println("Done Testning");
	}

	// Nested Class for Organising and Generalising Methods in a Group.
	@Nested
	@DisplayName("Arithmetic")
	class Arithmetic {
		@Test
		void testAdd() {
			assertEquals(4, ignite.add(1, 3), "Adding Method");
		}

		@Test
		@Tag("Math")
		@DisplayName("Substraction Method")
		void testSub() {
			assertEquals(31, ignite.sub(43, 12), "Substracting Method");
		}

		@Test
		@Tag("Math")
		void testMul() {
			assertEquals(144, ignite.mul(12, 12));
		}

		@Test
		@Tag("Math")
		@DisplayName("Divide Method")
		void testDiv() {
			assertEquals(23, ignite.div(69, 3));

			// Testing if Method Throws Arithmetic Exception
			// Pass
			assertThrows(ArithmeticException.class, () -> ignite.div(1, 0), " Dividing By 0");
			// Fails
//			assertThrows(NullPointerException.class, () -> ignite.div(1, 0), "Dividing By 0");

		}

	}

	@Test
	void calculateAreaCircle() {
		int radius = 20;
		assertEquals(Math.PI * radius * radius, ignite.calculateAreaCircle(radius), "Calculating Area of Circle");
	}

	@Nested
	@DisplayName("Enable and Disable Methods")
	class Enable_Disable {
		@Test
		@Disabled
		@DisplayName("In Progress Method")
		void disableTest() {
			fail("In Progess Method");
		}

		@Test
		@EnabledOnOs(OS.WINDOWS)
		void enableOnOS() {
			assertTrue(true, "I'm on MAC");
		}

		@Test
		@EnabledOnJre(JRE.JAVA_11)
		void enableOnJre() {
			assertTrue(true, "I'm Using Java 11");
		}

		// We Have More Options Like
		// EnabledIfSystemProperty
		// EnableIfEnvironmentVariable

		@Test
		@DisplayName("AsumeTrue")
		void assumeThat() {
			// Assume
			boolean isTrue = false;
			assumeTrue(isTrue);
		}

	}

	// assertAll
	@Nested
	@DisplayName("Assert Methods")
	class AssertAll {

		@Test
		@DisplayName("Assert All")
		void testMulAssertAll() {
//		assertEquals(144, ignite.mul(12, 12));

			assertAll(() -> assertEquals(144, ignite.mul(12, 12)), () -> assertEquals(0, ignite.mul(2, 0)),
					() -> assertEquals(144, ignite.mul(12, 12)));
		}

	}

	@Nested
	@DisplayName("Failed Message")
	class failedMessage {

		@Test
		@Disabled
		void failedMessageFunc() {
			fail(new Supplier<String>() {

				@Override
				public String get() {

					return null;
				}
			});
		}
	}

	// Repeated Test

	int radius = 20;

	@DisplayName("Repeat Test")
	@RepeatedTest(value = 3)
	void calculateAreaCircleRepeat(RepetitionInfo repInfo) {
		repInfo.getCurrentRepetition();
		repInfo.getTotalRepetitions();

		radius += 10;
		assertEquals(Math.PI * radius * radius, ignite.calculateAreaCircle(radius), "Calculating Area of Circle");
	}

	// Tagging

	@Tag("Circle")
	@DisplayName("Tagging Test")
	@Test
	void calculateAreaCircleTagging() {
		int radius = 10;
		assertEquals(Math.PI * radius * radius, ignite.calculateAreaCircle(radius), "Calculating Area of Circle");
	}

	// TestInfo & TestReported

	@Test
	void calculateAreaCircleInfoReported() {
		testReporter.publishEntry("Sunil", "Yadav");
		int radius = 10;
		assertEquals(Math.PI * radius * radius, ignite.calculateAreaCircle(radius), "Calculating Area of Circle");
	}

}
