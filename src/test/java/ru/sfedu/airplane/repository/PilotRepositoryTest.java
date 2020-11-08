package ru.sfedu.airplane.repository;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.sfedu.airplane.model.Pilot;
import ru.sfedu.airplane.repository.impl.CrudRepositoryImpl;
import ru.sfedu.airplane.repository.impl.PilotRepositoryImpl;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class PilotRepositoryTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(CrudRepository.class, CrudRepositoryImpl.class)
                .addClasses(Pilot.class, PilotRepository.class, PilotRepositoryImpl.class)
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    PilotRepository repository;

    @Test
    public void isNotNull() {
        System.out.println("=======================================================");
        Assert.assertNotNull(repository);
        System.out.println("=======================================================");
    }

    @Test
    public void testSave() {
        System.out.println("=======================================================");
        Pilot pilot = new Pilot("firstName", "lastName");
        repository.save(pilot);
        System.out.println(pilot.toString());
        Assert.assertNotNull(pilot.getId());
        System.out.println("=======================================================");
    }

    @Test
    public void testFindById() {
        System.out.println("=======================================================");
        System.out.println(repository.findById((long) 3).toString());
        System.out.println("=======================================================");
    }


}