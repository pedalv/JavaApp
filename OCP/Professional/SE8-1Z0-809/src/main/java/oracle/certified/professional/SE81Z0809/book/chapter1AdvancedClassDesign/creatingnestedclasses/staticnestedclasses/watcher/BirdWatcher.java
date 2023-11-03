package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.creatingnestedclasses.staticnestedclasses.watcher;

import oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.creatingnestedclasses.staticnestedclasses.bird.Toucan;

/*
Importing a static Nested Class
Importing a static nested class is interesting.
You can import it using a regular import:

import bird.Toucan.Beak;

And since it is static, alternatively you can use a static import:

import static bird.Toucan.Beak;

Either one will compile.
Surprising, isn’t it?
Java treats the static nested class as if it were a namespace.
 */
public class BirdWatcher {
    Toucan.Beak beak;
}
