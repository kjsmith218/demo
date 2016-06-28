package net.kjsmith;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("static-method")
public class MainTest {

	@Test
	public void testGet() {
		Assert.assertEquals(new Main().get(), "Hello world");
	}
}
