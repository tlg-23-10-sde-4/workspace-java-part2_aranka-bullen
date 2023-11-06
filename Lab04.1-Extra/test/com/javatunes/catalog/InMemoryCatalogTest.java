package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Callable;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        //fixture
        catalog = new InMemoryCatalog();

    }

    @Test
    public void numberInGenre_shouldReturnCorrectResult() {
       int result = catalog.numberInGenre(MusicCategory.POP);

       assertEquals(4, result);
    }

    @Test
    public void findBySelf_shouldReturnCollection_withSameArtistSameAsTitle() {
      Collection<MusicItem> items = catalog.selfTitledAlbulms();
      assertEquals(2, items.size());
      for(MusicItem item : items) {
          assertTrue(item.getArtist().equals(item.getTitle()));
          assertEquals(item.getArtist(), item.getTitle()); //alternative method
      }
    }

    @Test
    public void findByCategory_shouldReturnCollection_categoryFound() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        assertEquals(4, items.size());
        for(MusicItem item : items) {
            assertTrue(MusicCategory.POP == item.getMusicCategory());
            assertSame(MusicCategory.POP, item.getMusicCategory()); //alternative method for above
        }
    }

    @Test
    public void findByCategory_shouldReturnEmptyCollection_categoryNotFound() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.JAZZ);

        assertEquals(0, items.size());
        assertTrue(items.isEmpty()); //alternative method
    }

    @Test
    public void findById_shouldReturnTrue_whenIdFound() {
        MusicItem item =catalog.findById(12L);

        assertEquals(12L, item.getId().longValue());
        //assertEquals(12L, (long) item.getId());
        // primitive long(12L) and Object Long (.getId) therefore object Long needs to be downcast/
        //unwrap to the primitive long to be compared.

}

    @Test
    public void findById_shouldReturnNull_whenIdNotFound() {
        MusicItem item = catalog.findById(19L);
        assertNull(item);
        assertTrue(item == null);  //alternative method
    }
}