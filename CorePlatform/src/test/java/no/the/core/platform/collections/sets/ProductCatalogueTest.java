package no.the.core.platform.collections.sets;

import org.junit.jupiter.api.Test;

import static no.the.core.platform.collections.ProductFixtures.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;


public class ProductCatalogueTest {

    @Test
    public void shouldOnlyHoldUniqueProducts() throws Exception
    {
        ProductCatalogue catalogue = new ProductCatalogue();

        catalogue.isSuppliedBy(bobs);
        catalogue.isSuppliedBy(kates);

        assertThat(catalogue, containsInAnyOrder(door, floorPanel, window));

        /*
        ERROR:  not implement equals as hashCode methods:
        OUTPUT:
        Expected: iterable over [<Product{name='Wooden Door', weight=35}>,
                                 <Product{name='Floor Panel', weight=25}>,
                                 <Product{name='Glass Window', weight=10}>] in any order
                            but: Not matched: <Product{name='Glass Window', weight=10}>

         */
    }

    @Test
    public void treeShouldOnlyHoldUniqueProducts() throws Exception
    {
        TreeProductCatalogue catalogue = new TreeProductCatalogue();

        catalogue.isSuppliedBy(bobs);
        catalogue.isSuppliedBy(kates);

        assertThat(catalogue, containsInAnyOrder(door, floorPanel, window));
    }

    @Test
    public void shouldFindLightVanProducts() throws Exception
    {
        TreeProductCatalogue catalogue = new TreeProductCatalogue();

        catalogue.isSuppliedBy(bobs);
        catalogue.isSuppliedBy(kates);

        assertThat(catalogue.lightVanProducts(), containsInAnyOrder(window));
    }


    @Test
    public void shouldFindHeavyVanProducts() throws Exception
    {
        TreeProductCatalogue catalogue = new TreeProductCatalogue();

        catalogue.isSuppliedBy(bobs);
        catalogue.isSuppliedBy(kates);

        assertThat(catalogue.heavyVanProducts(), containsInAnyOrder(door, floorPanel));
    }


}