/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {




  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */

  @Test
  public void getInventory_shouldReturnReadOnlyCollection() {
    Collection<Television>tvs =Catalog.getInventory();
    tvs.clear(); // should throw exception
  }
  @Test
  public void findByBrands_shouldReturnEmptyMap_whenNoBrandPassed() {
    Map<String,Collection<Television>> tvMap = Catalog.findByBrands();

    assertTrue(tvMap.isEmpty());
  }
  @Test
  public void findBYBrand_shouldReturnPopulatedMap_whenBrandsPassed2() { //alternative method to test
   String[] brands = {"Sony", "Zenith", "RCA", "Magnavox"};
    Map<String, Collection<Television>> tvMap = Catalog.findByBrands(brands);

    assertEquals(brands.length, tvMap.size());

    for(String brand: brands) {
      verifyCollection(brand, tvMap.get(brand));
    }
  }


  @Test
  public void findBYBrand_shouldReturnPopulatedMap_whenBrandsPassed() {
    Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Sony", "Zenith");
    assertEquals(2, tvMap.size());

    Collection<Television> sonyTvs = tvMap.get("Sony");
    for(Television tv : sonyTvs) {
      assertEquals("Sony", tv.getBrand());
    }
    Collection<Television> zenithTvs = tvMap.get("Zenith");
    for(Television tv : zenithTvs) {
      assertEquals("Zenith", tv.getBrand());
    }
  }

  private void verifyCollection(String brand, Collection<Television> tvs) {
    for(Television tv : tvs){
      assertEquals(brand, tv.getBrand());
    }
  }

  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }
}