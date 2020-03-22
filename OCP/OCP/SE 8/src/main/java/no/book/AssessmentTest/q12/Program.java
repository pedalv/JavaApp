package no.book.AssessmentTest.q12;


/*
Suppose that we have the following property files and code.

Which bundle is used on lines 7 and 8, respectively?

Dolphins.properties
name=The Dolphin
age=0

Dolphins_fr.properties
name=Dolly

Dolphins_fr_CA.properties
name=Dolly
age=4

 */

import java.util.Locale;
import java.util.ResourceBundle;

public class Program {

    public static void main(String ... args) {
        Locale fr = new Locale("fr"); // Line 5
        ResourceBundle b = ResourceBundle.getBundle("Dolphins", fr); // Line 6
        b.getString("name"); // Line 7
        b.getString("age"); // Line 8
    }
}

/*
A. Dolphins.properties and Dolphins.properties
B. Dolphins.properties and Dolphins_fr.properties
C. Dolphins_fr.properties and Dolphins_fr.properties
D. Dolphins_fr.properties and Dolphins.properties
E. Dolphins_fr.properties and Dolphins_fr_CA.properties
F. Dolphins_fr_CA.properties and Dolphins_fr.properties

Answer
D.
Java will use Dolphins_fr.properties as the matching resource bundle on line 6
    because it is an exact match on the language.
Line 7 finds a matching key in this file.
Line 8 does not find a match in that file,
    and therefore it has to look higher up in the hierarchy.
For more information, see Chapter 5.
 */



    /**
     * Gets a resource bundle using the specified base name and locale,
     * and the caller's class loader. Calling this method is equivalent to calling
     * <blockquote>
     * <code>getBundle(baseName, locale, this.getClass().getClassLoader())</code>,
     * </blockquote>
     * except that <code>getClassLoader()</code> is run with the security
     * privileges of <code>ResourceBundle</code>.
     * See {@link #getBundle(String, Locale, ClassLoader) getBundle}
     * for a complete description of the search and instantiation strategy.
     *
     * @param baseName
     *        the base name of the resource bundle, a fully qualified class name
     * @param locale
     *        the locale for which a resource bundle is desired
     * @exception NullPointerException
     *        if <code>baseName</code> or <code>locale</code> is <code>null</code>
     * @exception MissingResourceException
     *        if no resource bundle for the specified base name can be found
     * @return a resource bundle for the given base name and locale
     */
    //@CallerSensitive
    //public static final ResourceBundle getBundle(String baseName,
    //                                             Locale locale)
//{
//      return getBundleImpl(baseName, locale,
//              getLoader(Reflection.getCallerClass()),
//              getDefaultControl(baseName));
//  }
