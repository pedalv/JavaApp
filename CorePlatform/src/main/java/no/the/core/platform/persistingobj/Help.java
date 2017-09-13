package no.the.core.platform.persistingobj;

import no.the.core.platform.multithreadingconcurrency.concurrency.AccountGroup;
import no.the.core.platform.multithreadingconcurrency.concurrency.BankAccount;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Help {

    public void saveAccount(BankAccount ba, String filename) {

        try(ObjectOutputStream objectStream =
            new ObjectOutputStream(
                    Files.newOutputStream(
                            Paths.get(filename))
            )) {
            //Serializes
            objectStream.writeObject(ba);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    BankAccount loadAccount(String filename) {
        BankAccount ba = null;

        try(ObjectInputStream objectStream =
            new ObjectInputStream((
                    Files.newInputStream(
                            Paths.get(filename))
                    ))) {
            //deserializes
            ba = (BankAccount) objectStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ba;
    }

    public void saveGroup(AccountGroup g, String filename) {

        try(ObjectOutputStream objectStream =
                    new ObjectOutputStream(
                            Files.newOutputStream(
                                    Paths.get(filename))
                    )) {
            //Serializes
            objectStream.writeObject(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    AccountGroup loadGroup(String filename) {
        AccountGroup g = null;

        try(ObjectInputStream objectStream =
                    new ObjectInputStream((
                            Files.newInputStream(
                                    Paths.get(filename))
                    ))) {
            //deserializes
            g = (AccountGroup) objectStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return g;
    }

}

/*
    ObjectOutputStream: Serializes object-graph to stream
    ObjectInputStrean: Deserializes stream to object-graph


    serialver <class>
    serialver -show
 */