package no.the.core.platform.collections.lists;

import org.junit.Test;

import static no.the.core.platform.collections.ProductFixtures.door;
import static no.the.core.platform.collections.ProductFixtures.floorPanel;
import static no.the.core.platform.collections.ProductFixtures.window;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;


public class ShipmentTest {

    private Shipment shipment = new Shipment();

    @Test
    public void shouldAddItems() throws Exception
    {
        shipment.add(door);
        shipment.add(window);


        assertThat(shipment, contains(door, window));
    }

    @Test
    public void shouldReplaceItems() throws Exception
    {
        shipment.add(door);
        shipment.add(window);

        shipment.replace(door, floorPanel);

        assertThat(shipment, contains(floorPanel, window));
    }

    @Test
    public void shouldNotReplaceMissingItems() throws Exception
    {
        shipment.add(window);

        shipment.replace(door, floorPanel);

        assertThat(shipment, contains(window));
    }

    @Test
    public void shouldIdentifyVanRequirements() throws Exception
    {
        shipment.add(door);
        shipment.add(window);
        shipment.add(floorPanel);

        shipment.prepare();

        assertThat(shipment.getLightVanProducts(), contains(window));
        assertThat(shipment.getHeavyVanProducts(), contains(floorPanel, door));
    }

}