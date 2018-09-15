package no.book.chapter1AdvancedClassDesign.reviewquestions.q18;

public class Swimmer {

    enum AnimalClasses {
        MAMMAL {
            @Override
            public boolean hasFins() {
                return false;
            }
        },
        FISH {
            public boolean hasFins() {
                return true;
            }},
        BIRD {
            @Override
            public boolean hasFins() {
                return false;
            }
        },
        REPTILE {
            @Override
            public boolean hasFins() {
                return false;
            }
        },
        AMPHIBIAN {
            @Override
            public boolean hasFins() {
                return false;
            }
        },
        INVERTEBRATE {
            @Override
            public boolean hasFins() {
                return false;
            }
        };

        public abstract boolean hasFins();
    }

    public static void main(String[] args) {
        System.out.println(AnimalClasses.FISH);
        //System.out.println(AnimalClasses.FISH.toString());
        System.out.println(AnimalClasses.FISH.ordinal());
        System.out.println(AnimalClasses.FISH.hasFins());
        System.out.println(AnimalClasses.BIRD.hasFins());
    }

}

/*
What is the result of the following code? (Choose all that apply.)

    A. fish
    B. FISH
    C. 0
    D. 1
    E. false
    F. true
G. The code does not compile.
/*
Error: java: no.book.chapter1AdvancedClassDesign.reviewquestions.q18.Swimmer.AnimalClasses
    is abstract; cannot be instantiated

Need implement all abstract methods

OUTPUT:
FISH
1
true
false
 */