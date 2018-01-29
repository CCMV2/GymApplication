package com.ubb.gymapp;

import com.ubb.gymapp.model.*;
import com.ubb.gymapp.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTimetableTest {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private WorkoutRepository workRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private TimetableRepository timeRepo;

    @Autowired
    private ClientTimetableRepository clientTimetableRepository;

    @Test
    public void addClientTimetable(){
        Client user = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        ClientTimetable userTimetable = new ClientTimetable(user, pro);
        userTimetable = clientTimetableRepository.save(userTimetable);
        assertNotNull(clientTimetableRepository.findOne(userTimetable.getId()));
        clientTimetableRepository.delete(userTimetable);
        timeRepo.delete(pro);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
        userRepo.delete(trainer);

    }

    @Transactional
    @Test
    public void FindOne(){
        Client user = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        ClientTimetable userTimetable = new ClientTimetable(user, pro);
        userTimetable = clientTimetableRepository.save(userTimetable);
        assertEquals(clientTimetableRepository.findOne(userTimetable.getId()), userTimetable);
        clientTimetableRepository.delete(userTimetable);
        timeRepo.delete(pro);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
        userRepo.delete(trainer);

    }

    @Test
    public void testDelete(){
        Client user = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        ClientTimetable userTimetable = new ClientTimetable(user, pro);
        userTimetable = clientTimetableRepository.save(userTimetable);
        clientTimetableRepository.delete(userTimetable);
        assertNull(clientTimetableRepository.findOne(userTimetable.getId()));
        timeRepo.delete(pro);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
        userRepo.delete(trainer);

    }

    @Transactional
    @Test
    public void Update(){
        Client user = new Client("a","a","a","a","a");
        Client user2 = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        ClientTimetable userTimetable = new ClientTimetable(user, pro);
        userTimetable = clientTimetableRepository.save(userTimetable);
        userTimetable.setClient(user2);
        clientTimetableRepository.save(userTimetable);
        ClientTimetable userTimetable2 = clientTimetableRepository.findOne(userTimetable.getId());
        assertEquals(userTimetable,userTimetable2);
        clientTimetableRepository.delete(userTimetable);
        timeRepo.delete(pro);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
        userRepo.delete(user2);
        userRepo.delete(trainer);
    }

    @Transactional
    @Test
    public void findAll(){
        Client user = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        ClientTimetable userTimetable = new ClientTimetable(user, pro);
        ClientTimetable userTimetable2 = new ClientTimetable(user, pro);
        ClientTimetable userTimetable3 = new ClientTimetable(user, pro);
        userTimetable = clientTimetableRepository.save(userTimetable);
        userTimetable2 = clientTimetableRepository.save(userTimetable2);
        userTimetable3 = clientTimetableRepository.save(userTimetable3);
        List<ClientTimetable> list = clientTimetableRepository.findAll();
        assertThat(list,hasItems(userTimetable,userTimetable2,userTimetable3));
        clientTimetableRepository.delete(userTimetable);
        clientTimetableRepository.delete(userTimetable2);
        clientTimetableRepository.delete(userTimetable3);
        timeRepo.delete(pro);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
        userRepo.delete(trainer);
    }

    @Transactional
    @Test
    public void findByUserandTimetable(){
        Client user = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        ClientTimetable userTimetable = new ClientTimetable(user, pro);
        userTimetable = clientTimetableRepository.save(userTimetable);
        assertEquals(clientTimetableRepository.findByClientAndTimetable(user,pro).getId(), userTimetable.getId());
        timeRepo.delete(pro);
        userRepo.delete(trainer);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
    }

    @Test
    public void deleteByUser(){
        Client user = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        ClientTimetable userTimetable = new ClientTimetable(user, pro);
        userTimetable = clientTimetableRepository.save(userTimetable);
        long id = userTimetable.getId();
        clientTimetableRepository.deleteByClient(user);
        boolean isDeleted = !clientTimetableRepository.exists(id);
        assertTrue(isDeleted);
        timeRepo.delete(pro);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
        userRepo.delete(trainer);
    }

    @Test
    public void deleteByTimetable(){
        Client user = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        ClientTimetable userTimetable = new ClientTimetable(user, pro);
        userTimetable = clientTimetableRepository.save(userTimetable);
        long id = userTimetable.getId();
        clientTimetableRepository.deleteByTimetable(pro);
        boolean isDeleted = !clientTimetableRepository.exists(id);
        assertTrue(isDeleted);
        timeRepo.delete(pro);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
        userRepo.delete(trainer);
    }
}