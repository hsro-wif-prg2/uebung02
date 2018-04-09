package ueb02;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StringSetTest {
	@Test
	void testStringSet() {
		StringSet impl = new StringSetImpl();
		String str = "In Ulm und um Ulm und um Ulm herum";

		for (String c : str.split(" ")) {
			impl.add(c);
		}

		System.out.println(impl);

		// sollte sein: In Ulm und um herum
		assertEquals(5, impl.size());

		// Elemente testen
		assertTrue(impl.contains("In"));
		assertTrue(impl.contains("Ulm"));
		assertFalse(impl.contains(""));
		assertFalse(impl.contains("Hans"));

		// zwei herausnehmen
		impl.remove("Ulm");
		impl.remove("um");
		assertThrows(NoSuchElementException.class, () -> impl.remove("Hams"));

		assertEquals(3, impl.size());

		System.out.println(impl);

		// nochmal Elemente testen
		assertFalse(impl.contains("Ulm"));
		assertFalse(impl.contains("um"));
		assertFalse(impl.contains("Hans"));
	}


}