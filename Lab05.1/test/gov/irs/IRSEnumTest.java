/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package gov.irs;

import com.javatunes.corp.Corporation;
import org.junit.Test;
import static org.junit.Assert.*;

//public class IRSEnumTest {
//
//    @Test
//    public void normalClientUsage() {
//        IRSEnum irs = IRSEnum.getInstance();  // or the  client can also say " = IRSEnum.INSTANCE"
//        irs.register(new Corporation("JavaTunes"));
//        irs.collectTaxes();
//    }
//
//    /**
//     * TASK: verify that two calls to IRSEnum.getInstance() return the same instance.
//     */
//    @Test
//    public void getInstance_shouldReturnSameInstance_everyTime() {
//    IRSEnum ire1 = IRSEnum.INSTANCE;
//    IRSEnum ire2 = IRSEnum.getInstance();
//    assertTrue(ire1 == ire2);
//    assertSame(ire1, ire2);  //assertSame does == check
//    }
//
//    /*
//     * Calling a static method loads the .class file.
//     * Show that any class load triggers creation of an enum type's instances.
//     * There is only one instance in this case (IRSEnum.INSTANCE).
//     */
//    @Test
//    public void classload_triggersInstanceCreation() {
//        // TODO: call IRSEnum.touch() and note the output
//        IRSEnum.touch();  // output creates IRSEnum ctor and loads the IRSEnum class
//
//    }
//
//}