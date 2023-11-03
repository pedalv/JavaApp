package no.insurance.Service;

import no.insurance.domain.User;
import no.insurance.repository.UserRepository;
import no.insurance.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by p on 29/10/2016.
 */
public class UserServiceTest {
    private User expectedUser;
    private List<User> expectedUsers;
    private Long userId1;

    @InjectMocks
    private UserService _userServiceMock;

    @Mock
    private UserRepository _userRepositoryMock;

    @Before
    public void setUp() throws Exception {
        expectedUsers = new ArrayList<User>();
        userId1 = 1L;
        expectedUser = new User(1L, "Pedro", "Alves", "alves.pedro0@gmail.com", "blabla");
        expectedUsers.add(expectedUser);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList() throws Exception {
        //MOCHITO
        when(_userRepositoryMock.findAll()).thenReturn(expectedUsers);

        List<User> actualUsers = _userServiceMock.list();

        assertNotNull(actualUsers);
        assertEquals(actualUsers.toArray().length,1);

        //verify if method was call
        verify(_userRepositoryMock).findAll();

        assertEquals( expectedUsers.get(0).getId().longValue(), actualUsers.get(0).getId().longValue() );

        //Hamcrest
        assertThat(expectedUsers.get(0).getId(), is(actualUsers.get(0).getId()));
    }

    @Test
    public void testCreate() throws Exception {
        User userCreate = new User(1L, "Pedro", "Alves", "alves.pedro0@gmail.com", "blabla");

        //MOCHITO
        when(_userRepositoryMock.save(userCreate)).thenReturn(userCreate);

        User created = _userServiceMock.create(userCreate);
        assertNotNull(created);

        //verify if method was call
        verify(_userRepositoryMock).save(userCreate);

        assertEquals(created.toString(),userCreate.toString());
    }

    @Test
    public void testGet() throws Exception {
        User usergetOne = new User(1L, "Pedro", "Alves", "alves.pedro0@gmail.com", "blabla");

        //MOCHITO
        when(_userRepositoryMock.findOne(1L)).thenReturn(usergetOne);

        User getActual = _userServiceMock.get(1L);
        assertNotNull(getActual);

        //verify if method was call
        verify(_userRepositoryMock).findOne(1L);
    }

    @Test
    public void testUpdate() throws Exception {

        User userfind = new User(1L, "Pedro", "Alves", "alves.pedro0@gmail.com", "blabla");
        User userChange = new User(1L, "Pedro", "Alves", "alves.pedro0@gmail.com", "my new passwors");

        //MOCHITO
        when(_userRepositoryMock.findOne(1L)).thenReturn(userfind);
        when(_userRepositoryMock.save(userChange)).thenReturn(userChange);

        _userServiceMock.update(1L, userChange);

        //verify if method was call
        verify(_userRepositoryMock).findOne(1L);
        verify(_userRepositoryMock).save(userfind);

        assertEquals(userfind.getPassword(),userChange.getPassword());
        assertNotNull(userfind);

    }

    @Test
    public void testDelete() throws Exception {

        User userdelete = new User(1L, "Pedro", "Alves", "alves.pedro0@gmail.com", "blabla");

        //MOCHITO
        when(_userRepositoryMock.findOne(1L)).thenReturn(userdelete);

        User userUpdated = _userServiceMock.delete(1L);

        //verify if method was call
        verify(_userRepositoryMock).findOne(1L);

    }
}
